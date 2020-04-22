package com.gupao.state;

/**
 * @Author Administrator
 * @Date 2020/4/22 15:35
 * 状态模式
 */
public class Test {
    public static void main(String[] args) {
        AppContext context = new AppContext();
        context.favorite();
        context.comment("这是一个好东西");
    }
}
