package com.gupao.strategy;

/**
 * @Author Administrator
 * @Date 2020/4/19 20:04
 */
public class JdPay extends Payment {
    @Override
    protected String getName() {
        return "京东";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
