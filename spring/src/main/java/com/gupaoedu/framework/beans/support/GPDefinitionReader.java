package com.gupaoedu.framework.beans.support;

import com.gupaoedu.framework.beans.config.GPBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author Administrator
 * @Date 2020/4/29 20:24
 */
public class GPDefinitionReader {
    private Properties contextConfig = new Properties();
    private List<String> registryBeanClasses = new ArrayList<String>();
    public GPDefinitionReader(String... configrationLocations) {
        doLoadConfig(configrationLocations[0]);
        //扫描配置文件中的类
        doScanner(contextConfig.getProperty("scanpackage"));
    }

    public List<GPBeanDefinition> loadBeanDefinitions() {
        List<GPBeanDefinition> list = new ArrayList<GPBeanDefinition>();
        try {
            for(String className:registryBeanClasses){
                Class<?> clazz = Class.forName(className);
                //保存类对应的ClassName(全类名)
                list.add(doCreateBeanDefinition(toLowerFirstCase(clazz.getSimpleName()), clazz.getName()));
                //接口
                for(Class<?> cls : clazz.getInterfaces()){
                    list.add(doCreateBeanDefinition(cls.getName(),clazz.getName()));
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }


    private GPBeanDefinition doCreateBeanDefinition(String beanName,String beanClassName){
        GPBeanDefinition definition = new GPBeanDefinition();
        definition.setFactoryBeanName(beanName);
        definition.setBeanClassName(beanClassName);
        return definition;
    }

    private void doScanner(String scanpackage) {
        URL url = this.getClass().getClassLoader().getResource("/"+scanpackage.replaceAll("\\.","/"));
        File files = new File(url.getFile());
        for (File file : files.listFiles()) {
            if(file.isDirectory()){
                doScanner(scanpackage+"."+file.getName());
            }else {
                if(!file.getName().endsWith(".class")){continue;}
                String className = scanpackage +"."+ file.getName().replace(".class","");
                registryBeanClasses.add(className);
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null != is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
