package com.gupao.decorator.v1;

public class BatterCakeWithEgg extends BatterCake{
    protected String getMsg(){
        return "煎饼"+"加一个鸡蛋";
    }

    public int getPrice(){
        return 6;
    }
}
