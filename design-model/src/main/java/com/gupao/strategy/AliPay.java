package com.gupao.strategy;

/**
 * @Author Administrator
 * @Date 2020/4/19 20:04
 */
public class AliPay extends Payment {
    @Override
    protected String getName() {
        return "阿里";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
