package com.gupao.singleton.threadlocal;

public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLoaclInstance =
            new ThreadLocal<ThreadLocalSingleton>(){
        protected ThreadLocalSingleton initialValue(){
            return new ThreadLocalSingleton();
        }
    };

    public static ThreadLocalSingleton getInstance(){
        return threadLoaclInstance.get();
    }
}
