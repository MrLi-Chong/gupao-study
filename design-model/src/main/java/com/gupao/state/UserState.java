package com.gupao.state;

/**
 * @Author Administrator
 * @Date 2020/4/22 15:20
 */
public abstract class UserState {
    protected AppContext appContext;

    public void setAppContext(AppContext appContext) {
        this.appContext = appContext;
    }


    public abstract void favorite();

    public abstract void comment(String content);
}
