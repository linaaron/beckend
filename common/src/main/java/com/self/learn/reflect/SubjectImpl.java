package com.self.learn.reflect;

import com.self.learn.reflect.inteface.Subject;

/**
 * Created by aaronl on 10/9/2015.
 */
public class SubjectImpl implements Subject {

    @Override
    public String say(String name, int age) {
        return name + "  " + age;
    }
}
