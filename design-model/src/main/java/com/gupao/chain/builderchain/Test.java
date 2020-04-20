package com.gupao.chain.builderchain;

/**
 * @Author Administrator
 * @Date 2020/4/19 21:25
 * 责任链模式
 */
public class Test {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        service.login("tom","666");
    }
}
