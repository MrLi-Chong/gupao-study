package com.gupao.singleton.threadlocal;

public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLoaclInstance =
            new ThreadLocal<ThreadLocalSingleton>(){

    };
}
