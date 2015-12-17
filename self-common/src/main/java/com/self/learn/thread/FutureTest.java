package com.self.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by aaronl on 10/10/2015.
 */
public final class FutureTest {

    public static void main(String[] args) throws Exception {
//        System.out.println(Runtime.getRuntime().availableProcessors());
        List<Future<String>> results = new ArrayList<Future<String>>();
        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es2 = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 100; i++) {
//            es.submit(new TaskRunnable());
//            es.submit(new TaskCallable());
//            results.add(es.submit(new TaskCallable()));
//            results.add(es.submit(new TaskFuture()));
//            es.execute(new TaskRunnable());

            results.add(es2.submit(new TaskCallable()));
            es2.submit(new FutureTest.TaskRunnable());
            es2.execute(new TaskRunnable());
        }

        results.forEach((Future<String> result) -> {
            try {
//                result.isDone();
                System.out.println(result.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static class TaskRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("runnable");
        }
    }

    public static class TaskCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("TaskCallable");
            return "callable";
        }
    }

    public static class TaskFuture implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("TaskCallable future");
            return "callable future";
        }
    }
}
