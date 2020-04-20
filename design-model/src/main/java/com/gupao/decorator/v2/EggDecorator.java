package com.gupao.decorator.v2;

public class EggDecorator extends BatterCakeDecorator{
    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    protected String getMsg(){
        return super.getMsg()+"加一个鸡蛋";
    }

    public int getPrice(){
        return super.getPrice()+1;
    }
}
