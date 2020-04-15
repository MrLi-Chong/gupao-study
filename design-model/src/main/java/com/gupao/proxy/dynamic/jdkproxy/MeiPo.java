package com.gupao.proxy.dynamic.jdkproxy;

import com.gupao.proxy.IPersion;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MeiPo implements InvocationHandler {
    private IPersion target;
    public IPersion getInstance(IPersion target){
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPersion) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after(){
        System.out.println("after");
    }

    private void before(){
        System.out.println("before");
    }
}
