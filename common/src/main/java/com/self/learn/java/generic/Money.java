package com.self.learn.java.generic;

/**
 * Created by aaronl on 1/20/2016.
 */
public interface Money<E> {
    E get(int index);

    boolean add(E e);
}
