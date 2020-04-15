package com.gupao.builder.simple;

public class Test {
    public static void main(String[] args) {
        CourseBulider bulider = new CourseBulider();
        bulider.addName("aaa");
        bulider.addNote("aaa");
        bulider.addPPt("aaa");
        bulider.addVideo("aaa");
        bulider.addHomeWork("aaa");
        System.out.println(bulider);
    }
}
