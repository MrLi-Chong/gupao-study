package com.gupao.decorator.v2;

public class Test {
    public static void main(String[] args) {
        BatterCake cake ;
        cake = new BaseBatterCake();
        cake = new EggDecorator(cake);
        cake = new EggDecorator(cake);
        cake = new SauageDecorator(cake);
        System.out.println(cake.getMsg()+cake.getPrice());
    }
}
