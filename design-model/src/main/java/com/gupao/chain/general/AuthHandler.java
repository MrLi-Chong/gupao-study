package com.gupao.chain.general;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 */
public class AuthHandler extends Handler {
    @Override
    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有权限操作");
            return;
        }
        System.out.println("登陆成功");
    }
}
