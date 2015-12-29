package com.self.learn.annotation;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> cla) {
        StringBuffer strFruitName = new StringBuffer("fruit name: ");
        StringBuffer strFruitColor = new StringBuffer("fruit color: ");

        Field[] fields = cla.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName.append(fruitName.value());
            }
            if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor.append(fruitColor.fruitColor().toString());
            }
        }

        System.out.println(strFruitName.toString());
        System.out.println(strFruitColor.toString());

//        fruit name: Apple
//        fruit color: RED
    }

    public static void main(String[] args) {
        getFruitInfo(Apple.class);
    }
}
