package com.gupao.composite;

/**
 * @Author Administrator
 * @Date 2020/4/17 21:49
 * 组合模式
 */
public abstract class Directory {
    protected String name;

    public Directory(String name) {
        this.name = name;
    }
    public abstract void showName();
}
