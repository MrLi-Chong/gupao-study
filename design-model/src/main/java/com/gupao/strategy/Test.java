package com.gupao.strategy;


/**
 * @Author Administrator
 * @Date 2020/4/19 20:15
 * 策略模式
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order("1","202004192016",435.44);
        System.out.println(order.pay());

    }
}
