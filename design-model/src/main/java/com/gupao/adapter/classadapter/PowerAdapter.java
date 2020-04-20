package com.gupao.adapter.classadapter;

/**
 * @Author Administrator
 * @Date 2020/4/18 18:12
 */
public class PowerAdapter extends Ac220 implements DC5 {
    public int output5V(){
        int adapterInput = super.output220V();
        int adapterOutput = adapterInput/44;
        System.out.println("使用变压器把220v转成"+adapterOutput);
        return adapterOutput;
    }
}
