package com.gupao.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/4/20 21:07
 */
public class Controller {
    private List<IAtion> actions = new ArrayList<IAtion>();

    public void add(IAtion action){
        actions.add(action);
    }
    public void execute(IAtion ation){
        ation.executeAction();
    }

    public void executes(){
        for (IAtion action :
                actions) {
            action.executeAction();
        }
        actions.clear();
    }
}
