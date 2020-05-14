package com.gupaoedu.framework.webmvc.servlet;

import com.gupaoedu.framework.annotation.*;
import com.gupaoedu.framework.context.GPApplicationContext;

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
 * 委派模式
 * 负责任务调度，请求分发
 */
public class GPDispatcherServlet extends HttpServlet {

    private GPApplicationContext applicationContext;

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

        method.invoke(applicationContext.getBean(beanName),new Object[]{request,response,params.get("name")[0]});

    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    @Override
    public void init(ServletConfig config){
        applicationContext = new GPApplicationContext(config.getInitParameter("contextConfigLocation"));
        //5.初始化HandlerMapping
        doInitHandlerMapping();
        System.out.println("运行结束");
        
    }

    private void doInitHandlerMapping() {
        if(this.applicationContext.getBeanDefinitionCount() == 0){return;}
        for (String beanName:this.applicationContext.getBeanDefinitionNames()) {
            Class clazz = this.applicationContext.getBean(beanName).getClass();
            if(!clazz.isAnnotationPresent(GPController.class)){continue;}
            String baseUrl = "";
            if(clazz.isAnnotationPresent(GPRequestMapping.class)){
                GPRequestMapping requestMapping = (GPRequestMapping) clazz.getAnnotation(GPRequestMapping.class);
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
}
