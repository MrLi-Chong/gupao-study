package com.gupao.chain.general;

import org.springframework.util.StringUtils;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 */
public class ValidateHandler extends Handler {

    @Override
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getUserName()) ||
                StringUtils.isEmpty(member.getPassword())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以继续往下执行");
        next.doHandler(member);
    }
}
