package com.self.learn.proxy;

import com.self.learn.proxy.impl.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class MyInvocationHandler implements InvocationHandler {

    //需要被代理的对象
    private Object target = null;

    //创建并返回一个动态代理
    public Object bind(Object obj) {
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
                .getClass().getInterfaces(), this);
        //3个参数分别为：类加载器;得到所有的接口;得到InvocationHandler接口的子类实例
    }

    //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
    //proxy 被代理的对象
    //要调用的方法
    //方法调用时的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args != null) {
            System.out.print("args:");
            for (Object val : args) {
                System.out.println(val);
            }
        } else {
            System.out.println("not args!");
        }
        //可以在method.invoke的前后加上所需的业务或者逻辑处理
        System.out.println("invoke begin.....................");
        Object temp = method.invoke(this.target, args);
        System.out.println("invoke end.......................");
        return temp;
    }

    public static void main(String[] args) {
        MyInvocationHandler demo = new MyInvocationHandler();
        Subject sub = (Subject) demo.bind(new SubjectImpl());
        sub.say("aaron", 16);
        sub.hello();

        /**
         result:
         args:aaron
         16
         invoke begin.....................
         aaron  16
         invoke end.......................
         not args!
         invoke begin.....................
         hello.....
         invoke end.......................
         **/
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
