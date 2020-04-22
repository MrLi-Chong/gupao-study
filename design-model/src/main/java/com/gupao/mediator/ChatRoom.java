package com.gupao.mediator;

/**
 * @Author Administrator
 * @Date 2020/4/22 19:58
 */
public class ChatRoom {
    public void sendMessage(User user,String message){
        System.out.println("["+user.getName()+"]:"+message);
    }
}
