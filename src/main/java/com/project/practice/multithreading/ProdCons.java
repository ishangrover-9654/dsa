package com.project.practice.multithreading;

import java.util.LinkedList;

public class ProdCons {

    public static void main(String[] args) {
        ProdConsDemo prodCons = new ProdConsDemo();
        Thread prod = new Thread(()-> {
            try {
                prodCons.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread cons = new Thread(()-> {
            try {
                prodCons.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        prod.start();
        cons.start();
    }


    public static class ProdConsDemo{
        LinkedList<Integer> queue = new LinkedList<>();
        private int limit = 10;
        int num = 0;
        public void produce() throws InterruptedException {
            synchronized (this){
                while (true){
                    while(queue.size()==limit){
                        wait();
                    }
                    Thread.sleep(1000);
                    System.out.println("Producing:"+num);
                    queue.add(num);
                    num++;
                    notify();
                }
                }

        }

        public void consume() throws InterruptedException {
            synchronized (this){
                while (true){
                    while(queue.size()==0){
                        wait();
                    }
                    Thread.sleep(1000);
                    System.out.println("Consuming:"+queue.poll());
                    notify();
                }
                }

        }
    }
}

class Producer implements Runnable{

    @Override
    public void run() {

    }
}

class Consumer implements Runnable{

    @Override
    public void run() {

    }
}
