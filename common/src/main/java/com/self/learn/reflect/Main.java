package com.self.learn.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
//        testPerson();
//        getInterfaces();
//        getConstructors();
//        getMethods();
        resetFlieds();
    }


    private static void testPerson() {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.self.learn.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Constructor<?> cons[] = demo.getConstructors(); //获取构造函数
        Class<?> supperClass = demo.getSuperclass();
        try {
            person = (Person) demo.newInstance();
            person1 = (Person) cons[0].newInstance("aaron", 12);
            person2 = (Person) cons[1].newInstance("boy");
            person3 = (Person) cons[2].newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        person.setName("Aaron");
        person.setAge(10);
        System.out.println(person);      //[Aaron  10 null null]
        System.out.println(cons.length); //3
        System.out.println(person1);     //[aaron  12 null null]
        System.out.println(person2);     //[null  0 boy null]
        System.out.println(person3);     //[null  0 null null]
        System.out.println("extend supper class: " + supperClass.getName()); //extend supper class: java.lang.Object
        for (int i = 0; i < cons.length; i++) {
            buildConstructors(cons[i]);
        }
//        Constructor method:   public com.self.learn.reflect.Person(java.lang.String arg0,int arg1){}
//        Constructor method:   public com.self.learn.reflect.Person(java.lang.String arg0){}
//        Constructor method:   public com.self.learn.reflect.Person(){}
    }

    private static void buildConstructors(Constructor<?> cons) {
        Class<?> p[] = cons.getParameterTypes();
        System.out.print("Constructor method:   ");
        int mo = cons.getModifiers();
        System.out.print(Modifier.toString(mo) + " ");
        System.out.print(cons.getName());
        System.out.print("(");
        for (int j = 0; j < p.length; ++j) {
            System.out.print(p[j].getName() + " arg" + j);
            if (j < p.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("){}\n");
    }

    private static void getInterfaces() {
        Class<?> person = null;
        try {
            person = Class.forName("com.self.learn.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> intes[] = person.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("implement interface1: " + intes[i].getName());
        }
//        implement interface1: com.self.learn.reflect.China
    }

    private static void getMethods() {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.self.learn.reflect.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();  //修饰符 private public等
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    private static void resetFlieds() {
        Person person = new Person();
        person.setName("aaron");
        person.setAge(2);
        person.setSex("m");
        person.setAddress("xiamen");
        System.out.println(person.toString());
        person.initializePerson(new Person());
        System.out.println(person.toString());
    }
}
