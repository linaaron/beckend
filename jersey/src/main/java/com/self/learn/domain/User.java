package com.self.learn.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by aaronl on 10/14/2015.
 */
@XmlRootElement
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private String userName = "";
    private int age = 0;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "name:" + userName + " age:" + age;
    }
}
