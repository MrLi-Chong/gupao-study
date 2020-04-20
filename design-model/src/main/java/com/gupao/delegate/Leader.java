package com.gupao.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020/4/19 14:56
 */
public class Leader implements IEmployee {
    private Map<String,IEmployee> map = new HashMap<>();

    public Leader() {
        map.put("开发",new EmployeeA());
        map.put("销售",new EmployeeB());
    }

    @Override
    public void doing(String task) {
        if(!map.containsKey(task)){
            System.out.println("不能胜任这个工作");
            return;
        }
        map.get(task).doing(task);
    }
}
