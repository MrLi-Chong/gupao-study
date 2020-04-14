package com.gupao.singleton.hungry;

/**
 * 优点 执行效率高
 * 缺点 类加载的时候就初始化，导致在某些情况下内存浪费
 */
public class HungrySingleton {
    private static final HungrySingleton hungrySingle = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return hungrySingle;
    }
}
