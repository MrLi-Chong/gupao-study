package com.gupao.decorator.gupaoclub;

public class VVipLoginTabDecorator extends BaseNoLoginTabDecorator {
    public VVipLoginTabDecorator(BaseNoLoginTab baseNoLoginTab) {
        super(baseNoLoginTab);
    }

    @Override
    protected String showTab() {
        return super.showTab()+"-作业-题库-成长墙-VVIP";
    }
}
