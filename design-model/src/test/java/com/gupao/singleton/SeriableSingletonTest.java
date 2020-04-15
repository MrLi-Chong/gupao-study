package com.gupao.singleton;

import com.gupao.singleton.seriable.SeriableSingleton;

import java.io.*;

public class SeriableSingletonTest {
    public static void main(String[] args) {
        SeriableSingleton s1 = null;
        SeriableSingleton s2 = SeriableSingleton.getInstance();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("ThreadLocalSingleton");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);
            oos.close();

            FileInputStream fis = new FileInputStream("ThreadLocalSingleton");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SeriableSingleton) ois.readObject();
            ois.close();

            System.out.println(s1);
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
