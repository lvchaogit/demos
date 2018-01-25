package com.demo.thread;

/**
 * 该类用于锁及线程示例
 * @author LC
 * @date 2018/1/5
 */
public class Demo {

    static  int i = 0;

    /**
     * class锁
     */
    public synchronized static void add() throws InterruptedException {
        if(Thread.interrupted()){
            throw new InterruptedException("线程被中断！");
        }
        i++;
    }

    /**
     * 实例对象锁
     */
    public synchronized  void addSyn(){
        i++;
    }

    /**
     * 实例对象锁
     */
    public  void addSyn2(){

        synchronized (this){
            i++;
        }

    }

}
 