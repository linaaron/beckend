package com.self.learn.reflect;

import com.self.learn.reflect.inteface.Fruit;

/**
 * Created by aaronl on 10/9/2015.
 */
public class Orange  implements Fruit {
    @Override
    public void eat() {
        System.out.println("ear orange");
    }
}
