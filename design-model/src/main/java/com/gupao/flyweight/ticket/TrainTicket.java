package com.gupao.flyweight.ticket;

import java.util.Random;

/**
 * @Author Administrator
 * @Date 2020/4/17 20:12
 */
public class TrainTicket implements ITicket{
    private String from;
    private String to;
    private int price;

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showInfo(String bunk) {
        this.price = new Random().nextInt(500);
        System.out.println("从"+from+"到"+to+bunk+"价格"+this.price);
    }
}
