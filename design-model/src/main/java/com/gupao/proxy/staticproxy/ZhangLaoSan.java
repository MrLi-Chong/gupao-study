package com.gupao.proxy.staticproxy;

import com.gupao.proxy.IPersion;

public class ZhangLaoSan implements IPersion {

    private ZhangSan zhangSan;

    public ZhangLaoSan(ZhangSan zhangSan) {
        this.zhangSan = zhangSan;
    }

    @Override
    public void findLove() {
        System.out.println("张老三开始物色");
        zhangSan.findLove();
        System.out.println("开始交往");
    }

    @Override
    public void buyIncure() {

    }
}
