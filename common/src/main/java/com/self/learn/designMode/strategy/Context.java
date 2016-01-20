package com.self.learn.designMode.strategy;

/**
 * Created by aaronl on 1/20/2016.
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface() {
        strategy.strategyInterface();
    }
}
