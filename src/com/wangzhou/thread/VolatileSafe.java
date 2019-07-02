package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/14
 * Time:14:29
 **/
public class VolatileSafe {
    private volatile boolean shutdown;
    public void close(){
        shutdown=true;
    }
    public void doWork(){
        while (!shutdown){
            System.out.println("safe...");
        }
    }
}
