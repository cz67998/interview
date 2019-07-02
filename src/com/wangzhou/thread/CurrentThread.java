package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:17:08
 **/
public class CurrentThread {
    public static void main(String[] args){
        System.out.println(Thread.currentThread().getName());
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.start();

    }
}
