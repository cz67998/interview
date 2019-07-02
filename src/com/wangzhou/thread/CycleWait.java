package com.wangzhou.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:9:28
 **/
public class CycleWait implements Runnable {
    private  String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }
    public static void main(String[] args) throws InterruptedException {
        CycleWait cw=new CycleWait();
        Thread t=new Thread(cw);
        //t.run();
        t.start();
        t.join();

        //LockSupport.park();
//       while(cw.value==null){
//           try {
//               Thread.currentThread().sleep(100);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//       }
        System.out.println(cw.value);
    }
}
