package com.project.create.practice.multithreading;

import jdk.nashorn.internal.ir.Block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPool {
    public static void main(String[] args) {
        CThreadPool pool = new CThreadPool(3);

        for (int i = 1; i <= 6; i++) {
            Task task = new Task(i);
            pool.submit(task);
        }

        pool.shutdown();
    }
}

class CThreadExecutor implements Runnable{

    BlockingQueue<Task> queue;
    static AtomicBoolean shutdown;

    public CThreadExecutor(BlockingQueue<Task> queue, AtomicBoolean shutdown) {
        this.queue = queue;
        this.shutdown = shutdown;
    }

    @Override
    public void run() {
        while (!this.shutdown.get()){
            String tName = Thread.currentThread().getName();
            Task task = queue.poll();

            if (task!=null){
                System.out.println("Task "+task.getTaskNum()+" started by thread :: "+tName);
                task.run();
                System.out.println("Task "+task.getTaskNum()+" end by thread :: "+tName);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CThreadPool{
    BlockingQueue<Task> queue ;
    Thread[] threads ;

    static AtomicBoolean shutdown = new AtomicBoolean(false);

    public CThreadPool(int size){
        threads = new Thread[size];
        queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(new CThreadExecutor(queue, shutdown), "Thread-"+i);
            threads[i].start();
        }
    }

    public void submit(Task task){
        queue.add(task);
    }

    public void shutdown() {
        shutdown.set(false); //= new AtomicBoolean(true);
    }
}

class Task implements Runnable{

    int taskNum;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Task(int taskNum) {
        this.taskNum = taskNum;
    }

    public int getTaskNum() {
        return taskNum;
    }
}
