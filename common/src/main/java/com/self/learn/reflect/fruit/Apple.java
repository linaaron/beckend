package com.self.learn.reflect.fruit;

import com.self.learn.reflect.fruit.impl.Fruit;

public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}