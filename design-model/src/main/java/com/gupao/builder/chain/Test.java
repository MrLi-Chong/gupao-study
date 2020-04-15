package com.gupao.builder.chain;

public class Test {
    public static void main(String[] args) {
        CourseBulider bulider = new CourseBulider();
        bulider.addName("aaa")
                .addNote("aaa")
                .addPPt("aaa")
                .addVideo("aaa")
                .addHomeWork("aaa");
        System.out.println(bulider.builder());
    }
}
