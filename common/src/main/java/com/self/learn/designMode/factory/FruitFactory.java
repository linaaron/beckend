package com.self.learn.designMode.factory;

import com.self.learn.designMode.factory.impl.Fruit;

public class FruitFactory {

    public static Fruit getInstance(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void main(String[] a) {
        Fruit apple = FruitFactory.getInstance("com.self.learn.designMode.factory.fruit.Apple");
        if (apple != null) {
            apple.eat();
        }

        Fruit orange = FruitFactory.getInstance("com.self.learn.designMode.factory.fruit.Orange");
        if (orange != null) {
            orange.eat();
        }

        /**
          result: eat apple
                  eat orange
        **/
    }
}
