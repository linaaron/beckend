package com.self.learn.proxy;

import com.self.learn.proxy.impl.Subject;

public class SubjectImpl implements Subject {

    @Override
    public void say(String name, int age) {
        System.out.println(name + "  " + age);
    }

    @Override
    public void hello() {
        System.out.println("hello.....");
    }
}
