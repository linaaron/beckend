package com.self.learn.reflect;

import java.lang.reflect.Field;

public class Person implements China {
    private String name;
    private int age;
    private String sex;

    public String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "[" + this.name + "  " + this.age + " " + this.sex + " " + this.address + "]";
    }

    public void sayChina() {
        System.out.println("hello , china");
    }

    public void sayEnglish(String name, int age) {
        System.out.println(name + "  " + age);
    }

    public void initializePerson(Person person) {
//        Field[] fields = Person.class.getDeclaredFields(); //获取person所有的filed
        Field[] fields = Person.class.getFields();       //获取person和父类的 public filed
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
