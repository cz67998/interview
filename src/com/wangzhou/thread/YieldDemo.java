package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:15:42
 **/
public class YieldDemo {
    public static void main(String[] args) {
        Runnable yieldTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + i);
                    if (i == 5) {
                        Thread.yield();
                    }
                }
            }
        };
        new Thread(yieldTask, "A").start();
        new Thread(yieldTask, "B").start();
    }
}
