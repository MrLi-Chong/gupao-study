package com.gupao.decorator.v2;

public class BatterCakeDecorator extends BatterCake{
    private BatterCake batterCake;
    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected String getMsg(){
        return this.batterCake.getMsg();
    }

    public int getPrice(){
        return this.batterCake.getPrice();
    }
}
