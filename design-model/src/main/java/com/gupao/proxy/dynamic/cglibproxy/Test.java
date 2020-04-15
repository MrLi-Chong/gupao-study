package com.gupao.proxy.dynamic.cglibproxy;


public class Test {
    public static void main(String[] args) {
        CglibMeiPo cglibMeiPo = new CglibMeiPo();
        ZhangSan instance = (ZhangSan)cglibMeiPo.getInstance(ZhangSan.class);
        instance.findLove();
    }
}
