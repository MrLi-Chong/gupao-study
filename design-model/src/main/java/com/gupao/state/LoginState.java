package com.gupao.state;

/**
 * @Author Administrator
 * @Date 2020/4/22 15:21
 */
public class LoginState extends UserState {
    @Override
    public void favorite() {
        System.out.println("收藏");
    }

    @Override
    public void comment(String content) {
        System.out.println("评论："+content);
    }
}
