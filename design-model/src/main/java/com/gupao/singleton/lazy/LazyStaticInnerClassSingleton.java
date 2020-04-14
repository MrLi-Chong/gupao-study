package com.gupao.singleton.lazy;

/**
 * classpath:LazyStaticInnerClassSingleton.class
 *          LazyStaticInnerClassSingleton$LazyHolder.class
 * 优点：写法优雅，线程安全，效率高，利用了java本身的语法
 * 缺点：能够被反射破坏
 */
public class LazyStaticInnerClassSingleton {
    private LazyStaticInnerClassSingleton(){
        if(LazyHolder.INSTANCE != null){
            throw new RuntimeException("不允许非法访问");
        }
    }
    public static LazyStaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
