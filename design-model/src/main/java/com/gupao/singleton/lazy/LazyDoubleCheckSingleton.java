package com.gupao.singleton.lazy;

/**
 * 优点：性能高，线程安全
 * 缺点：程序可读性加大，不够优雅
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton lazySingleton;
    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        //检查是否要阻塞
        if(lazySingleton == null){
            synchronized(LazyDoubleCheckSingleton.class){
                //检查是否要重新创建实例
                if(lazySingleton == null){
                    lazySingleton = new LazyDoubleCheckSingleton();
                    //指令重排序问题，加上volatile关键字
                }
            }
        }
        return lazySingleton;
    }
}
