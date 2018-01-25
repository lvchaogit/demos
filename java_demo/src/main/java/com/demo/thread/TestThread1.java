package com.demo.thread;

/**
 * @author LC
 * @date 2018/1/5
 */
public class TestThread1 implements Runnable {

    private Demo demo;

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Demo.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程中断！");
                break;
            }
            System.out.println("----------------静态方法调用完毕-------------");
            this.getDemo().addSyn2();
            System.out.println("----------------休眠方法调用完毕-------------");
        }

    }
}
 