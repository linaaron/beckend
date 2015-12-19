package com.self.learn.javaTest.bean;

public class TestBean {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s", this.id, this.name);
    }

    private static String tryCatchTest() {
        try {
            return "1";
        } catch (Exception E) {
            return "2";
        } finally {
            return "3";
        }
    }

    public static void main(String[] args) {
        System.out.println(tryCatchTest());
    }
}
