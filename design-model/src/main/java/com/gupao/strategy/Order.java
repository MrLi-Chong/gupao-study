package com.gupao.strategy;

/**
 * @Author Administrator
 * @Date 2020/4/19 20:05
 */
public class Order {
    private String uid;
    private String orderId;
    private double amount;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public MsyResult pay(){
        return pay(null);
    }

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public MsyResult pay(String payKey){
        Payment payment = PayStrategy.pay(payKey);
        System.out.println("欢迎使用："+payment.getName());
        System.out.println("本次交易金额为"+amount+",开始扣款");
        return payment.pay(uid,amount);
    }
}
