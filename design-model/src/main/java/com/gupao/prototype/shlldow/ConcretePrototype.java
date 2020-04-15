package com.gupao.prototype.shlldow;

import java.util.List;

public class ConcretePrototype implements Cloneable {
    private String age;
    private String name;
    private List<String> hibby;

    public List<String> getHibby() {
        return hibby;
    }

    public void setHibby(List<String> hibby) {
        this.hibby = hibby;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConcretePrototype clone(){
        try {
            return (ConcretePrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "ConcretePrototype{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", hibby=" + hibby +
                '}';
    }
}
