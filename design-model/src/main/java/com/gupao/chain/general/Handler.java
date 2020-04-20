package com.gupao.chain.general;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:24
 */
public abstract class Handler {
    protected Handler next;
    public void next(Handler next) {
        this.next = next;
    }

    public abstract void doHandler(Member member);
}
