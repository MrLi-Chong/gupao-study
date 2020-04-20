package com.gupao.flyweight.ticket;

/**
 * @Author Administrator
 * @Date 2020/4/17 20:20
 */
public class Test {
    public static void main(String[] args) {
        ITicket ticket = TicketFactory.queryTicket("北京","信阳");
        ticket.showInfo("硬座");
    }
}
