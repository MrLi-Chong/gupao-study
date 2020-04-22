package com.gupao.state;

/**
 * @Author Administrator
 * @Date 2020/4/22 15:24
 */
public class AppContext {
    public static final UserState LOGIN_STATE = new LoginState();
    public static final UserState UNLOGIN_STATE = new UnLoginState();

    private UserState curentState = UNLOGIN_STATE;

    {
        LOGIN_STATE.setAppContext(this);
        UNLOGIN_STATE.setAppContext(this);
    }
    public void setState(UserState state){
        this.curentState = state;
    }

    public UserState getState(){
        return this.curentState;
    }

    public void favorite() {
        this.curentState.favorite();
    }

    public void comment(String content) {
        this.curentState.comment(content);
    }
}
