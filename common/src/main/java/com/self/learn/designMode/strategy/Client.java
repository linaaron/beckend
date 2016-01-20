package com.self.learn.designMode.strategy;

/**
 * Created by aaronl on 1/20/2016.
 */
public class Client {

    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        Strategy strategy = new ConcreteStrategyA();
        //创建环境
        Context context = new Context(strategy);
        //调用方法
        context.contextInterface();
    }
}
