package com.gupao.facade.general;

/**
 * 门面模式
 */
public class Test {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.doA();
        facade.doB();
        facade.doC();
    }
}
