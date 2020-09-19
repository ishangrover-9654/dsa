package com.project.practice.multithreading;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    static List<BaseHealthChecker> healthCheckers = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        healthCheckers.add(new ApplicationHealthChecker(countDownLatch, "Application"));
        healthCheckers.add(new NetworkHealthChecker(countDownLatch, "Network"));

        healthCheckers.stream().forEach(healthChecker -> {
            Thread t = new Thread(healthChecker);
            t.start();
        });

        countDownLatch.await();
        System.out.println("All Services are fine");
        System.out.println("Exiting...");


    }
}

@Getter
abstract class BaseHealthChecker implements Runnable{

    private CountDownLatch countDownLatch;
    private String serviceName;
    private boolean serviceUp = false;

    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }

    @Override
    public void run() {
        try {
            verifyService();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public abstract void verifyService() throws InterruptedException;
}

class NetworkHealthChecker extends BaseHealthChecker{


    public NetworkHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super(countDownLatch, serviceName);
    }

    @Override
    public void verifyService() throws InterruptedException {
        System.out.println("Checking "+getServiceName());
        Thread.sleep(5000);
        System.out.println(getServiceName()+" Health is fine...");
        getCountDownLatch().countDown();
    }
}

class ApplicationHealthChecker extends BaseHealthChecker{


    public ApplicationHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super(countDownLatch, serviceName);
    }

    @Override
    public void verifyService() throws InterruptedException {
        System.out.println("Checking "+getServiceName());
        Thread.sleep(5000);
        System.out.println(getServiceName()+" Health is fine...");
        getCountDownLatch().countDown();
    }
}
