package com.gupao.composite;

/**
 * @Author Administrator
 * @Date 2020/4/18 13:32
 */
public class FileDirectory extends Directory {
    public FileDirectory(String name) {
        super(name);
    }

    @Override
    public void showName() {
        System.out.println(this.name);
    }


}
