package com.self.learn.arithmetic.sort;

import com.self.learn.arithmetic.sort.bubbleSort.BubbleSorter;

import java.util.Comparator;

/**
 * Created by aaronl on 1/20/2016.
 */
public class Client {

    public static void main(String[] args) {
        Sorter sorter = new BubbleSorter();

        SorterContext context = new SorterContext(sorter);

        Integer[] test = new Integer[]{6, 3, 1, 8, 4};
        Integer[] test2 = new Integer[]{6, 3, 1, 8, 4};

        context.sort(test);  //1,3,4,6,8
        System.out.print("===========");

        class comp implements Comparator {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer) o1 < (Integer) o2 ? 1 : 0;
            }
        }

        System.out.print("===========");
        context.sort(test2, new comp());//8,6,4,3,1
        System.out.print("===========");
    }
}
