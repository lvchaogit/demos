package com.demo.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author LC
 * @date 2018/1/5
 */
public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        Demo demo = new Demo();
        //访问类的静态方法
        TestThread1 testThread1 = new TestThread1();
        testThread1.setDemo(demo);
        Thread thread = new Thread(testThread1);
        //非静态锁方法
        TestThread2 testThread2 = new TestThread2();
        testThread2.setDemo(demo);
        Thread thread2 = new Thread(testThread2);
        thread.start();
        thread2.start();
        TimeUnit.SECONDS.sleep(2);
        //中断线程
        thread.interrupt();
        while (true) {
            System.out.println(thread.isInterrupted());
            TimeUnit.SECONDS.sleep(10);
        }

    }
}
 