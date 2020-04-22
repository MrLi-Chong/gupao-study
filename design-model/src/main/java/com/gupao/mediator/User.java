package com.gupao.mediator;

/**
 * @Author Administrator
 * @Date 2020/4/22 19:58
 * 中介者模式
 */
public class User {
    private String name;
    private ChatRoom chatRoom;

    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void senMsg(String message){
        System.out.println("["+this.name+"]:"+message);
    }
}
