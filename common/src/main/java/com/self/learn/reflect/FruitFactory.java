package com.self.learn.reflect;

import com.self.learn.reflect.inteface.Fruit;

/**
 * Created by aaronl on 10/9/2015.
 */
public class FruitFactory {

    public static void main(String[] a) {
        Fruit apple = FruitFactory.getInstance("com.self.learn.reflect.Apple");
        if (apple != null) {
            apple.eat();
        }

        Fruit orange = FruitFactory.getInstance("com.self.learn.reflect.Orange");
        if (orange != null) {
            orange.eat();
        }
    }

    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
