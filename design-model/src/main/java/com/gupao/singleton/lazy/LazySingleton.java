package com.gupao.singleton.lazy;

/**
 * 优点：节省内存
 * 缺点：线程不安全
 */
public class LazySingleton {
    private static LazySingleton lazySingleton;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
