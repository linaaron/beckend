package com.self.learn.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> futures = new ArrayList<Future<String>>();

        for (int i = 0; i < 5; i++) {
//            executorService.submit(new TaskWithResult(i));
            futures.add(executorService.submit(new TaskWithResult(i)));
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }

    static class TaskWithResult implements Callable<String> {
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Call() begin: " + Thread.currentThread().getName());
            Thread.sleep(2000);
            return "call method result: " + id + Thread.currentThread().getName();
        }
    }
}
