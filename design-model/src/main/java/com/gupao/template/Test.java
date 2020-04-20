package com.gupao.template;

/**
 * @Author Administrator
 * @Date 2020/4/19 15:45
 * 模板模式
 */
public class Test {
    public static void main(String[] args) {
        AbstractCourse course = new JavaCourse();
        course.setNeedCheckHomework(false);
        course.createCourse();

        AbstractCourse course1 = new PythonCourse();
        course1.createCourse();
    }
}
