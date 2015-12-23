package com.self.learn.reflect;

public class Demo {

    public static void main(String[] args) {
        Class<?> demo1 = null;
        Class<? extends Demo> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("com.self.learn.reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("Class Name: " + demo1.getName());
        System.out.println("Class Name: " + demo2.getName());
        System.out.println("Class Name: " + demo3.getName());

        /**
         result:
         Class Name: com.self.learn.reflect.Demo
         Class Name: com.self.learn.reflect.Demo
         Class Name: com.self.learn.reflect.Demo
         **/
    }
}
