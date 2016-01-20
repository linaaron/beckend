package com.self.learn.designMode.factory;

import com.self.learn.designMode.factory.impl.Fruit;

public class Apple implements Fruit {
    @Override
    public void eat() {
        System.out.println("eat apple");
    }
}
