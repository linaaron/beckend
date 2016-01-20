package com.self.learn.java;

import com.self.learn.java.bean.JavaBean;

import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        JavaBean javaBeanOne = new JavaBean("1", "aaron", 18, 88.88);

        System.out.println("javaBeanOne: " + javaBeanOne);

        FileOutputStream fos = new FileOutputStream("serial");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(javaBeanOne);
        oos.flush();
        oos.close();

        JavaBean javaBeanTwo;
        FileInputStream fis = new FileInputStream("serial");
        ObjectInputStream ois = new ObjectInputStream(fis);
        javaBeanTwo = (JavaBean) ois.readObject();
        ois.close();
        System.out.println("javaBeanTwo: " + javaBeanTwo);
    }
}
