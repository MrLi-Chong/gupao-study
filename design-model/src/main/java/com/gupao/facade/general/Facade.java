package com.gupao.facade.general;

public class Facade {
    SubSystemA subSystemA = new SubSystemA();
    SubSystemB subSystemB = new SubSystemB();
    SubSystemC subSystemC = new SubSystemC();

    public void doA(){
        subSystemA.doA();
    }

    public void doB(){
        subSystemB.doB();
    }

    public void doC(){
        subSystemC.doC();
    }
}
