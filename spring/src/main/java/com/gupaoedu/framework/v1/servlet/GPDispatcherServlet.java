package com.gupaoedu.framework.v1.servlet;

import com.gupaoedu.framework.annotation.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @Author Administrator
 * @Date 2020/4/26 19:57
 */
public class GPDispatcherServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private List<String> classNames = new ArrayList<String>();

    //Ioc容器，
    private Map<String,Object> ioc = new HashMap<String,Object>();

    private Map<String,Method> handlerMapping = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            this.doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception,Detail:"+Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = request.getRequestURI();
        String contextPath = request.getContextPath();
        url = contextPath.replaceAll(contextPath,"").replaceAll("/+","/")+url;
        if(!this.handlerMapping.containsKey(url)){
            response.getWriter().write("404 Not Found");
            return;
        }
        Map<String,String[]> params = request.getParameterMap();
        Method method = handlerMapping.get(url);

        //获取形参列表
        Class<?>[] paramterTypes = method.getParameterTypes();
        Object[] parameterValue = new Object[paramterTypes.length];
        for (int i = 0; i < paramterTypes.length; i++) {
            Class paramterType = paramterTypes[i];
            if(paramterType == HttpServletRequest.class){
                parameterValue[i] = request;
            }else if(paramterType == HttpServletResponse.class){
                parameterValue[i] = response;
            }else if(paramterType == String.class){
                //运行时的状态
                Annotation[] [] pa = method.getParameterAnnotations();
                for (int j = 0; j < pa.length; j++) {
                    for (Annotation a:pa[j]){
                        if(a instanceof GPRequestParam){
                            String paramName = ((GPRequestParam) a).value();
                            if(!"".equals(paramName)){
                                String value = Arrays.toString(params.get(paramName)).
                                        replaceAll("\\[|\\]","").
                                        replaceAll("\\s+","");
                                parameterValue[i] = value;
                            }
                        }
                    }
                }

            }
        }

        String beanName = toLowerFirstCase(method.getDeclaringClass().getSimpleName());

        method.invoke(ioc.get(beanName),new Object[]{request,response,params.get("name")[0]});

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2.扫描相关的类
        doScanner(contextConfig.getProperty("scanpackage"));
        //==============Ioc部分=============
        //3.初始化Ioc容器,将扫描到的类实例化，保存到Ioc容器中
        doInstance();
        //Aop在这个位置
        //==============DI部分=============
        //4.完成依赖注入
        doAutowired();
        //5.初始化HandlerMapping
        doInitHandlerMapping();
        System.out.println("运行结束");
        
    }

    private void doInitHandlerMapping() {
        if(ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry:ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if(!clazz.isAnnotationPresent(GPController.class)){continue;}
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                baseUrl = requestMapping.value();
            }
            for(Method method:clazz.getMethods()){
                if(!method.isAnnotationPresent(GPRequestMapping.class)){ continue; }
                GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                String url = ("/" + baseUrl + "/" + requestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
            }
        }
    }

    private void doAutowired() {
        if(ioc.isEmpty()){return;}
        for (Map.Entry<String,Object> entry:ioc.entrySet()) {
            for(Field field:entry.getValue().getClass().getDeclaredFields()){
                if(!field.isAnnotationPresent(GPAutowired.class)){continue;}
                GPAutowired gpAutowired = field.getAnnotation(GPAutowired.class);
                String beanName = gpAutowired.value().trim();
                if("".equals(beanName)){
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        if(classNames.isEmpty()){return;}
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(GPController.class)){
                    String beanName = toLowerFirstCase(clazz.getSimpleName());
                    Object instance = clazz.newInstance();
                    ioc.put(beanName,instance);
                }else if(clazz.isAnnotationPresent(GPService.class)){
                    String beanName = clazz.getAnnotation(GPService.class).value();
                    if("".equals(beanName)){
                        beanName = toLowerFirstCase(clazz.getSimpleName());
                    }
                    Object instance = clazz.newInstance();
                    ioc.put(beanName,instance);
                    for(Class<?> i:clazz.getInterfaces()){
                        if(ioc.containsKey(i.getName())){
                            throw new Exception("The "+i.getName()+" is Exists");
                        }
                        ioc.put(i.getName(),instance);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
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
                classNames.add(className);
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
