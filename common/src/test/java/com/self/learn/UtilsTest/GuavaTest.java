package com.self.learn.UtilsTest;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GuavaTest {

    @Test
    public void partitionTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List partitionList = Lists.partition(list, 2);
        System.out.println(partitionList);
    }
}
