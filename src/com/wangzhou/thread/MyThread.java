package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:17:26
 **/
public class MyThread extends Thread {
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "::" + name);
        }
    }

    public static void main(String[] args) {
        new MyThread("tom").start();
        new MyThread("tom1").start();
        new MyThread("tom2").start();
        new MyThread("tom3").start();
    }
}
