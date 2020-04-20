package com.gupao.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020/4/20 20:12
 */
public class CourseAggregateImpl implements ICourseAggregate {
    private List courseList ;

    public CourseAggregateImpl() {
        this.courseList = new ArrayList();
    }

    @Override
    public void add(Course course) {
        courseList.add(course);
    }

    @Override
    public void remove(Course course) {
        courseList.remove(course);
    }

    @Override
    public Iterator<Course> iterator() {
        return new IteratorImpl<>(courseList);
    }
}
