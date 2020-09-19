package com.project.practice.multithreading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class CustomThreadPool2 {

    public static void main(String[] args) {
        ThreadPool2 threadPool2 = new ThreadPool2(2);
        for (int i = 0; i < 2; i++) {
            Task task = new Task(i);
            threadPool2.submit(task);
        }
    }

}

class ThreadPool2 {
    int poolSize;
    Thread[] threads;
    BlockingDeque<Task> task2Queue;

    public ThreadPool2(int poolSize) {
        this.poolSize = poolSize;
        threads = new Thread[poolSize];
        task2Queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < poolSize; i++) {
            threads[i] = new Thread(new Executor(task2Queue));
            threads[i].start();
        }
    }

    public void submit(Task task){
        task2Queue.add(task);
    }
}

class Executor implements Runnable{

    BlockingDeque<Task> task2Queue;
    public Executor(BlockingDeque<Task> task2Queue) {
        this.task2Queue = task2Queue;
    }

    @Override
    public void run() {

        while (true){
            if (!task2Queue.isEmpty() ){
                task2Queue.poll().run();
            }
        }

    }
}






