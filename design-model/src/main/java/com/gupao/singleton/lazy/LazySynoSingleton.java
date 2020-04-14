package com.gupao.singleton.lazy;

/**
 * 优点：节省内存,线程安全
 * 缺点：性能低
 */
public class LazySynoSingleton {
    private static LazySynoSingleton lazySingleton;
    private LazySynoSingleton(){}
    public synchronized static LazySynoSingleton getInstance(){
        if(lazySingleton == null){
            lazySingleton = new LazySynoSingleton();
        }
        return lazySingleton;
    }
}
