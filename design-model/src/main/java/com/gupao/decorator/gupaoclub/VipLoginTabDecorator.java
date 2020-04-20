package com.gupao.decorator.gupaoclub;

public class VipLoginTabDecorator extends BaseNoLoginTabDecorator{

    public VipLoginTabDecorator(BaseNoLoginTab baseNoLoginTab) {
        super(baseNoLoginTab);
    }
    @Override
    protected String showTab() {
        return super.showTab()+"-作业-题库-成长墙";
    }
}
