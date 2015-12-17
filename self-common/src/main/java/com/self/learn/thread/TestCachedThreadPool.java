package com.self.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by aaronl on 10/10/2015.
 */
public class TestCachedThreadPool {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
//            executorService.submit(new TestRunnable());
            executorService.execute(new TestRunnable());
            System.out.println("***********  " + i + "  ***********");
        }
        executorService.shutdown();
    }

    static class TestRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " thread is invoked");
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
