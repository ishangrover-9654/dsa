package com.project.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableConcepts {
    static int POOL_SIZE = 2;
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
        for (int i = 0; i < POOL_SIZE; i++) {
            executor.submit(new TaskRC());
        }

        executor.shutdown();
    }

}

class TaskRC implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

class TaskSem {

}
