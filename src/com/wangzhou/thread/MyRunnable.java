package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:17:35
 **/
public class MyRunnable implements Runnable {
    private String name;

    MyRunnable(String name) {
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
        new Thread(new MyRunnable("TOM1")).start();
        new Thread(new MyRunnable("TOM2")).start();
        new Thread(new MyRunnable("TOM3")).start();
    }
}
