package com.gupao.chain.builderchain;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:24
 */
public class LoginHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        System.out.println("登陆成功！");
        member.setRoleName("普通用户");
        next.doHandler(member);
    }
}
