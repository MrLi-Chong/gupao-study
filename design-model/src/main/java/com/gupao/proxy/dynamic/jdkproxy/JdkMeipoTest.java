package com.gupao.proxy.dynamic.jdkproxy;

import com.gupao.proxy.IPersion;

public class JdkMeipoTest {
    public static void main(String[] args) {
        MeiPo meiPo = new MeiPo();
        IPersion persion = meiPo.getInstance(new ZhangSan());
        persion.findLove();
        persion.buyIncure();
    }
}
