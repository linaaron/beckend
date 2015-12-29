package com.self.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public final class FutureTest {

    public static void main(String[] args) throws Exception {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        List<Future<String>> Futures = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
//        ExecutorService es2 = Executors.newFixedThreadPool(cpuNum * 2);
        for (int i = 0; i < 100; i++) {
//            es.submit(new TaskRunnable());
//            es.submit(new TaskCallable());
            Futures.add(es.submit(new TaskCallable()));
//            es.execute(new TaskRunnable());

//            Futures.add(es2.submit(new TaskCallable()));
//            es2.submit(new FutureTest.TaskRunnable());
//            es2.execute(new TaskRunnable());
        }

        Futures.forEach((Future<String> future) -> {
            try {
//                future.isDone();
                System.out.println(future.get());//future.get 获取结果
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //实现runnable 没有返回值
    public static class TaskRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("runnable");
        }
    }

    //实现callable 有返回值
    public static class TaskCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("TaskCallable");
            return "callable";
        }
    }

}
