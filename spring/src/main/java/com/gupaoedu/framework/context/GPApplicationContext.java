package com.gupaoedu.framework.context;

import com.gupaoedu.framework.annotation.GPAutowired;
import com.gupaoedu.framework.annotation.GPController;
import com.gupaoedu.framework.annotation.GPService;
import com.gupaoedu.framework.beans.GPBeanWrapper;
import com.gupaoedu.framework.beans.config.GPBeanDefinition;
import com.gupaoedu.framework.beans.support.GPDefinitionReader;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020/4/29 20:13
 */
public class GPApplicationContext {

    private GPDefinitionReader reader;
    private Map<String, GPBeanDefinition> beanDefinitionMap = new HashMap<String, GPBeanDefinition>();
    private Map<String,GPBeanWrapper> factoryBeanInstanceCache = new HashMap<String,GPBeanWrapper>();
    private Map<String,Object> factoryBeanObjectCache = new HashMap<String,Object>();

    public GPApplicationContext(String... configrationLocations) {
        try {
            //1.加载配置文件
            reader = new GPDefinitionReader(configrationLocations);
            //2.解析配置文件封装成BeanDefinition
            List<GPBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();
            //3.把BeanDefinition缓存起来
            doRegisterBeanDefinition(beanDefinitions);
            //4.完成依赖注入
            doAutowired();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doAutowired() {
        for(Map.Entry<String,GPBeanDefinition> entry:this.beanDefinitionMap.entrySet()){
            String beanName = entry.getKey();
            getBean(beanName);
        }

    }

    private void doRegisterBeanDefinition(List<GPBeanDefinition> beanDefinitions) throws Exception{
        for (GPBeanDefinition beanDefinition : beanDefinitions) {
            if(!beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())){
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + "is exists");
            }
            beanDefinitionMap.put(beanDefinition.getFactoryBeanName(),beanDefinition);
            beanDefinitionMap.put(beanDefinition.getBeanClassName(),beanDefinition);
        }
    }

    public Object getBean(String beanName){
        //1.先拿到BeanDefiniton配置信息
        GPBeanDefinition definition = this.beanDefinitionMap.get(beanName);
        //2.反射实例化instance
        Object instance = instancetionBean(beanName,definition);
        //3.封装成一个beanwrapper
        GPBeanWrapper beanWrapper = new GPBeanWrapper(instance);
        //4.保存到Ioc容器
        factoryBeanInstanceCache.put(beanName,beanWrapper);
        //5.执行依赖注入
        populateBean(beanName,definition,beanWrapper);
        return beanWrapper.getWrapperInstance();
    }

    private void populateBean(String beanName, GPBeanDefinition definition, GPBeanWrapper beanWrapper) {
        //可能涉及到循环依赖？
        //A{ B b}
        //B{ A b}
        //用两个缓存，循环两次
        //1、把第一次读取结果为空的BeanDefinition存到第一个缓存
        //2、等第一次循环之后，第二次循环再检查第一次的缓存，再进行赋值
        Object instance = beanWrapper.getWrapperInstance();
        Class<?> clazz = beanWrapper.getWrapperClass();
        if(!(clazz.isAnnotationPresent(GPController.class) || clazz.isAnnotationPresent(GPService.class))){
            return;
        }

        for(Field field:clazz.getDeclaredFields()){
            if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
            GPAutowired gpAutowired = field.getAnnotation(GPAutowired.class);
            String autoBeanName = gpAutowired.value().trim();
            if("".equals(autoBeanName)){
                autoBeanName = field.getType().getName();
            }
            field.setAccessible(true);
            try {
                if(this.factoryBeanInstanceCache.get(autoBeanName) == null){
                    continue;
                }
                field.set(instance,this.factoryBeanInstanceCache.get(autoBeanName).getWrapperInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object instancetionBean(String beanName, GPBeanDefinition definition) {
        String className = definition.getBeanClassName();
        Object instance = null;
        try {
            if(this.factoryBeanObjectCache.containsKey(beanName)){
                instance = this.factoryBeanObjectCache.get(beanName);
            }else {
                Class<?> clazz = Class.forName(className);
                instance = clazz.newInstance();
                this.factoryBeanObjectCache.put(beanName,instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Object getBean(Class beanClass){
        return getBean(beanClass.getName());
    }

    public int getBeanDefinitionCount(){
        return beanDefinitionMap.size();
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }
}
