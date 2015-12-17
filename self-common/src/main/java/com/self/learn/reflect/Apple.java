package com.self.learn.reflect;

import com.self.learn.reflect.inteface.Fruit;

/**
 * Created by aaronl on 10/9/2015.
 */
public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
