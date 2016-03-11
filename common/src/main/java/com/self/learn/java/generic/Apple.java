package com.self.learn.java.generic;

import java.util.List;

/**
 * Created by aaronl on 1/20/2016.
 */
public class Apple<T> {

    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public <E> void price() {

    }

//    ?泛型通配符
    public  void color(List<? extends T> str) {

    }
}
