package com.self.learn.reflect;

import java.lang.reflect.Field;

/**
 * Created by aaronl on 10/9/2015.
 */
public class Person implements China {
    private String name;
    private int age;
    private String sex;

    public String test;

    public Person() {

    }

    public Person(String sex) {
        this.sex = sex;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "[" + this.name + "  " + this.age + this.sex + this.test + "]";
    }

    public void sayChina() {
        System.out.println("hello , china");
    }

    public void sayEnglish(String name, int age) {
        System.out.println(name + "  " + age);
    }

    public void initializePersion(Person person) {
        Field[] fields = Person.class.getDeclaredFields();
        Field[] fields2 = Person.class.getFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                field.set(this, field.get(person));
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException(e);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
