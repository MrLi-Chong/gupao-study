package com.gupao.mediator;

/**
 * @Author Administrator
 * @Date 2020/4/22 20:01
 */
public class Test {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User tom = new User("Tom",chatRoom);
        User jake = new User("jack",chatRoom);
        tom.senMsg("hi,I am tom");
        jake.senMsg("hello,I am jack");
    }
}
