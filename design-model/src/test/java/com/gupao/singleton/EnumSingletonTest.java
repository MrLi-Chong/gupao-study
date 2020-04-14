package com.gupao.singleton;

import com.gupao.singleton.register.EnumSingleton;

import java.lang.reflect.Constructor;

public class EnumSingletonTest {
    public static void main(String[] args) {
//        EnumSingleton enumSingleton = EnumSingleton.getInstance();
//        enumSingleton.setData(new Object());
        Class<?> clazz = EnumSingleton.class;
        try {
            Constructor classes = clazz.getDeclaredConstructor(String.class,int.class);
            classes.setAccessible(true);
            Object object = classes.newInstance();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
