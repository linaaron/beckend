package com.self.learn.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class JobMain {

    private static ApplicationContext context = null;
    static final String[] path = {"classpath:spring.xml"};
    static final String[] classpath = {"spring.xml"};

    private static void init() {
        try {
            context = new FileSystemXmlApplicationContext(path);
            System.out.println("111111111111111111111111");
        } catch (Exception e) {
            try {
                context = new FileSystemXmlApplicationContext(classpath);
                System.out.println("2222222222222222222222222");
            } catch (Exception e2) {
                try {
                    context = new ClassPathXmlApplicationContext(classpath);
                    System.out.println("3333333333333333333333333333333");
                } catch (Exception e3) {
                    e3.printStackTrace();
                    System.out.println("44444444444444444444444");
                }
            }
        }
    }

    public static void main(String[] args) {
        init();
    }

}
