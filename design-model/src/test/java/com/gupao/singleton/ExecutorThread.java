package com.gupao.singleton;

import com.gupao.singleton.threadlocal.ThreadLocalSingleton;

public class ExecutorThread implements Runnable {
    @Override
    public void run() {
        ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+instance);
    }
}
