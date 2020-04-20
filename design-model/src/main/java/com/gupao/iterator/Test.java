package com.gupao.iterator;

/**
 * @Author Administrator
 * @Date 2020/4/20 20:21
 */
public class Test {
    public static void main(String[] args) {
        Course java = new Course("java");
        Course python = new Course("python");
        Course c = new Course("c");
        Course cshop = new Course("cshop");
        CourseAggregateImpl courseAggregate = new CourseAggregateImpl();
        courseAggregate.add(java);
        courseAggregate.add(python);
        courseAggregate.add(c);
        courseAggregate.add(cshop);
        Iterator<Course> i = courseAggregate.iterator();
        while (i.hasNext()){
            Course course = i.next();
            System.out.println("《"+course.getName()+"》");
        }
    }
}
