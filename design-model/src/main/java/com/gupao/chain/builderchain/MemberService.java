package com.gupao.chain.builderchain;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 */
public class MemberService {
    public void login(String loginName,String password){
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(new Member(loginName,password));
    }
}
