package com.self.learn.arithmetic.search;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by aaronl on 1/20/2016.
 */
//二分查找
public class BinarySearch {

    public <T> int binarySearch(T[] list, T key, Comparator<T> comp) {
        Arrays.sort(list);
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = comp.compare(list[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public <T extends Comparable<T>> int binarySearch(T[] list, T key) {
        Arrays.sort(list);
        int low = 0;
        int high = list.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = list[mid].compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }
}
