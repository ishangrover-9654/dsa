package com.project.practice.multithreading;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProdCons2 {
    public static void main(String[] args) {
        Queue<Integer> integers = new LinkedList<>();
        Thread prodThread = new Thread(new Producer2(integers, 5));
        Thread consThread = new Thread(new Consumer2(integers));

        prodThread.start();
        consThread.start();
    }
}

class Producer2 extends Thread{

    int item = 0;
    Queue<Integer> queue;
    int size;

    public Producer2(Queue<Integer> queue, int size) {
        this.queue = queue;
        this.size = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                produce(item++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int item) throws InterruptedException {
        synchronized (queue){
            while (queue.size() == size){
                //System.out.println("Producer waiting");
                queue.wait();
            }
                System.out.println("Produced "+ item);
                queue.add(item);
                queue.notifyAll();
            Thread.sleep(1000);
        }
    }


    public synchronized void produce2(int item) throws InterruptedException {

            while (queue.size() == size){
                //System.out.println("Producer waiting");
                wait();
            }
            System.out.println("Produced "+ item);
            queue.add(item);
            notifyAll();
            Thread.sleep(1000);
        }

}

class Consumer2 implements Runnable{

    Queue<Integer> queue;

    public Consumer2(Queue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void consume() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                //System.out.println("Consumer Waiting");
                queue.wait();
            }
            System.out.println("Consumed "+ queue.remove());
            queue.notifyAll();
            Thread.sleep(1000);
        }
    }
}
