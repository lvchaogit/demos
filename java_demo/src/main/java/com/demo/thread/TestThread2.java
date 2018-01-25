package com.demo.thread;

/**
 * @author LC
 * @date 2018/1/5
 */
public class TestThread2  implements Runnable {
    private Demo demo;

    public Demo getDemo() {
        return demo;
    }

    public void setDemo(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        this.getDemo().addSyn();
        System.out.println("----------------非静态方法调用完毕-------------");
    }
}
 