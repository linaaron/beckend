package com.self.learn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//我们运行一个线程都是显式的调用Thread的start方法。现在我们可以用concurrent厦门的方法来实现
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.submit(new TestRunnable()); //有返回值
//            executorService.execute(new TestRunnable()); //执行相应的线程,无返回值
            System.out.println("***********  " + i + "  ***********");
        }
        executorService.shutdown();//并不是终止线程，而是禁止在向executor新增新的任务
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
