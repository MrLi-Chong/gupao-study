package com.gupao.flyweight.ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Administrator
 * @Date 2020/4/17 20:15
 */
public class TicketFactory {
    private static Map<String,ITicket> pool = new ConcurrentHashMap<>();
    public static ITicket queryTicket(String from,String to){
        String key = from + "->" + to;
        if(pool.containsKey(key)){
            System.out.println("使用缓存"+key);
           return pool.get(key);
        }
        ITicket ticket = new TrainTicket(from,to);
        pool.put(key,ticket);
        return ticket;
    }
}
