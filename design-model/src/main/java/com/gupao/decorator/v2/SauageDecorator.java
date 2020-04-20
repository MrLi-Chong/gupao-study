package com.gupao.decorator.v2;

public class SauageDecorator extends BatterCakeDecorator{
    public SauageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    protected String getMsg(){
        return super.getMsg()+"加一个香肠";
    }

    public int getPrice(){
        return super.getPrice()+2;
    }
}
