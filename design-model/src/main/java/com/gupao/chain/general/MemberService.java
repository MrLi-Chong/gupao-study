package com.gupao.chain.general;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 */
public class MemberService {
    public void login(String loginName,String password){
        Handler validateHandler = new ValidateHandler();
        Handler loginHandler = new LoginHandler();
        Handler authHandler = new AuthHandler();
        validateHandler.next(loginHandler);
        loginHandler.next(authHandler);
        validateHandler.doHandler(new Member(loginName,password));
    }
}
