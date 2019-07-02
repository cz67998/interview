package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:14:23
 **/
public class WaitSleepDemo {
    public static void main(String[] args) throws InterruptedException {
         final Object lock=new Object();
         new Thread(()->{
             System.out.println(Thread.currentThread().getName());
             synchronized (lock){
                 System.out.println("get lock");
                 try {
                     Thread.sleep(20);
                     System.out.println("wait");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 try {
                     lock.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println("done");
             }
         },"Thread A").start();

        Thread.sleep(200);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            synchronized (lock){
                System.out.println("b get lock");
                try {
                    Thread.sleep(2000);
                    System.out.println("b wait");
                    lock.notify();
                    Thread.sleep(1000);
                    Thread.yield();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("b bdone");
            }
        },"Thread b").start();

    }
}
