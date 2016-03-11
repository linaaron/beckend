package com.self.learn.arithmetic.sort;

import java.util.Comparator;

/**
 * Created by aaronl on 1/20/2016.
 */
public class SorterContext {

    private Sorter sorter;

    public SorterContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public <T extends Comparable<T>> void sort(T[] list) {
        sorter.sort(list);
    }

    public <T> void sort(T[] list, Comparator<T> comp) {
        sorter.sort(list, comp);
    }
}
