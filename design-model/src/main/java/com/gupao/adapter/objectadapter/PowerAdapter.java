package com.gupao.adapter.objectadapter;

import com.gupao.adapter.classadapter.DC5;

/**
 * @Author Administrator
 * @Date 2020/4/18 18:12
 */
public class PowerAdapter implements DC5 {
    private Ac220 ac220;
    public int output5V(){
        int adapterInput = ac220.output220V();
        int adapterOutput = adapterInput/44;
        System.out.println("使用变压器把220v转成"+adapterOutput);
        return adapterOutput;
    }
}
