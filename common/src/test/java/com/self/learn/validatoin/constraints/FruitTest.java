package com.self.learn.validatoin.constraints;

import com.self.learn.annotation.FruitColor;
import com.self.learn.annotation.FruitName;
import org.junit.Test;

public class FruitTest {

    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String appleColor;


    @Test
    public void test() {
        FruitTest fruitTest = new FruitTest();

        System.out.print(fruitTest.getAppleName());
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

}
