package com.gupao.delegate;

/**
 * @Author Administrator
 * @Date 2020/4/19 14:53
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String task) {
        System.out.println("我是员工A,我擅长销售，现在开始做"+task);
    }
}
