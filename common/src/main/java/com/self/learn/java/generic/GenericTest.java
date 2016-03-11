package com.self.learn.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaronl on 1/20/2016.
 */
public class GenericTest {

    public static void main(String[] args) {

        Integer[] a = new Integer[]{7,4,9,2};

        List<String> list = new ArrayList();
        list.add("qqyumidi");
        list.add("corn");
//        list.add(100);

//        Integer a = 3;
//        String b = String.valueOf(3);

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i); // 1
            System.out.println("name:" + name);
        }
    }
}
