package com.gupao.decorator.gupaoclub;

public class Test {
    public static void main(String[] args) {
        NoLoginTab tab = new BaseNoLoginTab() ;
        System.out.println(tab.showTab());
        VipLoginTabDecorator vip = new VipLoginTabDecorator(new BaseNoLoginTab());
        System.out.println(vip.showTab());
        VVipLoginTabDecorator vvip = new VVipLoginTabDecorator(new BaseNoLoginTab());
        System.out.println(vvip.showTab());
    }
}
