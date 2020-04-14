package com.gupao.singleton;

import com.gupao.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

public class ReflectTest {
    public static void main(String[] args) {
        Class<?> clazz = LazyStaticInnerClassSingleton.class;
        try {
            Constructor classes = clazz.getDeclaredConstructor(null);
            classes.setAccessible(true);
            Object object = classes.newInstance();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
