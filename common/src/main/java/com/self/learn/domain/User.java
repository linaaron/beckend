package com.self.learn.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }
        User user = (User)obj;
        return this.name.equals(user.getName());
    }

    @Override
    public int hashCode() {
        final int PRIME =31;
        int result =1;
        result = PRIME * result + getAge();
        return result;
    }

    @Override
    public String toString(){
        return "name: " + this.name + " age: " + this.age
                + " address: " + this.address;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setName("aaronl");
        user.setAge(12);
        user.setAddress("xiamen");

        User user2 = new User();
        user2.setName("aaronl");
        user2.setAge(12);
        user2.setAddress("xiamen");

        System.out.println(user.equals(user2));
        System.out.println(user==user2);

        Set<User> users = new HashSet<>();
        users.add(user);
        users.add(user2);
        System.out.println(users);
//        System.out.println(user.hashCode());
//        System.out.println(user);
    }
}
