package com.gupao.prototype.deep;

import java.io.*;
import java.util.List;

/**
 * 性能不好
 * 只要实现clone方法都是浅克隆
 * 怎么做才能深克隆：1.序列化，2.转json
 */
public class ConcretePrototype implements Cloneable ,Serializable{
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

    public ConcretePrototype deepClone(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (ConcretePrototype) ois.readObject();
        } catch (Exception e) {
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
