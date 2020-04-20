package com.gupao.delegate;

/**
 * @Author Administrator
 * @Date 2020/4/19 14:59
 */
public class Boss {
    public void command(String task,Leader leader){
        leader.doing(task);
    }
}
