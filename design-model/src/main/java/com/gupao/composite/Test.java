package com.gupao.composite;

import java.io.File;

/**
 * @Author Administrator
 * @Date 2020/4/18 13:55
 */
public class Test {
    public static void main(String[] args) {
        FileDirectory qq = new FileDirectory("qq.exe");
        FileDirectory wx = new FileDirectory("wx.exe");

        PathDirectory pathDirectory = new PathDirectory("办公软件",2);
        FileDirectory word = new FileDirectory("ppt");
        FileDirectory doc = new FileDirectory("doc");
        FileDirectory excel = new FileDirectory("excel");
        pathDirectory.add(word);
        pathDirectory.add(doc);
        pathDirectory.add(excel);
        PathDirectory root = new PathDirectory("D",1);
        root.add(qq);
        root.add(wx);
        root.add(pathDirectory);
        root.showName();
    }
}
