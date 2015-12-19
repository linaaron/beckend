package com.self.learn.reflect;

import com.self.learn.reflect.inteface.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by aaronl on 10/9/2015.
 */
public class Main {

    public static void main(String[] args) {
//        testDemo();
//        testPerson();
//        getInterfaces();
//        getConstructors();
//        getMothods();
//        testInvocationHandler();
        resetFileds();
    }

    private static void testInvocationHandler() {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new SubjectImpl());
        String info = sub.say("aaron", 16);
        System.out.println(info);
    }


    private static void testDemo() {
        Class<?> demo1 = null;
        Class<? extends Demo> demo2 = null;
        Class<?> demo3 = null;
        try {
            demo1 = Class.forName("com.self.learn.reflect.Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        demo2 = new Demo().getClass();
        demo3 = Demo.class;

        System.out.println("Class Name: " + demo1.getName());
        System.out.println("Class Name: " + demo2.getName());
        System.out.println("Class Name: " + demo3.getName());
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
        Constructor<?> cons[] = demo.getConstructors();
        Class<?> supperClass = demo.getSuperclass();
        try {
            person = (Person) demo.newInstance();
            person1 = (Person) cons[0].newInstance();
            person2 = (Person) cons[1].newInstance("aaron", 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
        person.setName("Aaron");
        person.setAge(10);
        System.out.println(person);
        System.out.println(cons.length);
        System.out.println(person1);
        System.out.println(person2);
        System.out.println("extend supper class: " + supperClass.getName());
        for (int i = 0; i < cons.length; i++) {
            System.out.println("constructor method: " + cons[i]);
        }
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
            System.out.println("implement interface: " + intes[i].getName());
        }
    }

    private static void getConstructors() {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.self.learn.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?>[] cons = demo.getConstructors();
        Arrays.stream(cons).forEach((Constructor<?> con) -> buildConstructors(con));
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

    private static void getMothods(){
        Class<?> demo=null;
        try{
            demo=Class.forName("com.self.learn.reflect.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Method method[]=demo.getMethods();
        for(int i=0;i<method.length;++i){
            Class<?> returnType=method[i].getReturnType();
            Class<?> para[]=method[i].getParameterTypes();
            int temp=method[i].getModifiers();
            System.out.print(Modifier.toString(temp)+" ");
            System.out.print(returnType.getName()+"  ");
            System.out.print(method[i].getName()+" ");
            System.out.print("(");
            for(int j=0;j<para.length;++j){
                System.out.print(para[j].getName()+" "+"arg"+j);
                if(j<para.length-1){
                    System.out.print(",");
                }
            }
            Class<?> exce[]=method[i].getExceptionTypes();
            if(exce.length>0){
                System.out.print(") throws ");
                for(int k=0;k<exce.length;++k){
                    System.out.print(exce[k].getName()+" ");
                    if(k<exce.length-1){
                        System.out.print(",");
                    }
                }
            }else{
                System.out.print(")");
            }
            System.out.println();
        }
    }

    private static void resetFileds(){
        Person person = new Person();
        person.setName("a");
        person.setAge(2);
        person.setSex("m");
        person.setTest("a1");
        System.out.println(person.toString());
        person.initializePersion(new Person());
        System.out.println(person.toString());
    }
}
