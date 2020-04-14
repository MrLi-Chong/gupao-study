package com.gupao.singleton;

import com.gupao.singleton.register.ContainerSingleton;

public class ContainerSingletonTest {
    public static void main(String[] args) {
        Object instance1 = ContainerSingleton.getInstance("com.gupao.singleton.PoJo");
        Object instance2 = ContainerSingleton.getInstance("com.gupao.singleton.PoJo");
        System.out.println(instance1 == instance2);
    }
}
