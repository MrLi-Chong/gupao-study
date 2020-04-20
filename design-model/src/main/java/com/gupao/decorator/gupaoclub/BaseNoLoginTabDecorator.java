package com.gupao.decorator.gupaoclub;

public class BaseNoLoginTabDecorator extends  BaseNoLoginTab{

    private BaseNoLoginTab baseNoLoginTab;

    public BaseNoLoginTabDecorator(BaseNoLoginTab baseNoLoginTab) {
        this.baseNoLoginTab = baseNoLoginTab;
    }

    @Override
    protected String showTab() {
        return this.baseNoLoginTab.showTab();
    }

}
