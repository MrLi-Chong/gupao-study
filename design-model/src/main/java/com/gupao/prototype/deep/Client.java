package com.gupao.prototype.deep;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype();
        prototype.setAge("18");
        prototype.setName("tom");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        prototype.setHibby(list);

        ConcretePrototype prototype1 = prototype.deepClone();
        prototype1.getHibby().add("3");
        System.out.println(prototype);
        System.out.println(prototype1);
    }
}
