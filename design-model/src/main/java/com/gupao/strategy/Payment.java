package com.gupao.strategy;

/**
 * @Author Administrator
 * @Date 2020/4/19 19:55
 */
public abstract class Payment {
    protected abstract String getName();

    public MsyResult pay(String name,double count){
        if(queryBalance(name) < count){
            return new MsyResult("500","支付失败","余额不足");
        }
        return new MsyResult("200","支付成功","支付金额"+count);
    }

    protected abstract double queryBalance(String uid);
}
