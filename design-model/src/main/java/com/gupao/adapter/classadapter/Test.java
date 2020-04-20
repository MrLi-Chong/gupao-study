package com.gupao.adapter.classadapter;

/**
 * @Author Administrator
 * @Date 2020/4/18 18:15
 * 适配器模式
 */
public class Test {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter();
        adapter.output5V();
        adapter.output220V();
    }
}
