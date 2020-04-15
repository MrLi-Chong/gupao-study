package com.gupao.builder.chain;

import com.gupao.builder.simple.Course;

public class CourseBulider {
    private Course course = new Course();

    public CourseBulider addName(String name){
        course.setName(name);
        return this;
    }

    public CourseBulider addPPt(String ppt){
        course.setPpt(ppt);
        return this;
    }
    public CourseBulider addVideo(String video){
        course.setVideo(video);
        return this;
    }
    public CourseBulider addNote(String note){
        course.setNote(note);
        return this;
    }
    public CourseBulider addHomeWork(String homework){
        course.setHomework(homework);
        return this;
    }
    public Course builder(){
        return course;
    }
}
