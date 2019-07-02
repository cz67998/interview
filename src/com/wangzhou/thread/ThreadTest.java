package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:17:17
 **/
public class ThreadTest {
    private static void attack() {
        System.out.println("Fight");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            attack();
        });
        System.out.println("current main thread is:"+Thread.currentThread().getName());
        thread.run();
        thread.start();
    }
}
