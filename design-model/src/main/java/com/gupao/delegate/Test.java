package com.gupao.delegate;

/**
 * @Author Administrator
 * @Date 2020/4/19 15:01
 * 委派模式
 */
public class Test {
    public static void main(String[] args) {
        new Boss().command("开发",new Leader());
        new Boss().command("销售",new Leader());
        new Boss().command("画图",new Leader());
    }
}
