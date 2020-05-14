package com.gupaoedu.framework.beans;

/**
 * @Author Administrator
 * @Date 2020/4/29 21:01
 */
public class GPBeanWrapper {
    private Object wrapperInstance;
    private  Class<?> wrapperClass;

    public GPBeanWrapper(Object instance) {
        this.wrapperInstance = instance;
        this.wrapperClass = instance.getClass();
    }

    public Object getWrapperInstance() {
        return wrapperInstance;
    }

    public void setWrapperInstance(Object wrapperInstance) {
        this.wrapperInstance = wrapperInstance;
    }

    public Class<?> getWrapperClass() {
        return wrapperClass;
    }

    public void setWrapperClass(Class<?> wrapperClass) {
        this.wrapperClass = wrapperClass;
    }
}
