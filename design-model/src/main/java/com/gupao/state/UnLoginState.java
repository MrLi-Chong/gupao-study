package com.gupao.state;

/**
 * @Author Administrator
 * @Date 2020/4/22 15:22
 */
public class UnLoginState extends UserState {

    @Override
    public void favorite() {
        this.switchToLogin();
        this.appContext.getState().favorite();
    }

    @Override
    public void comment(String content) {
        this.switchToLogin();
        this.appContext.getState().comment(content);
    }

    private void switchToLogin(){
        System.out.println("登陆");
        this.appContext.setState(this.appContext.LOGIN_STATE);
    }
}
