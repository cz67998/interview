package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:19:46
 **/
public class SyncBlockAndMethod {
    public void syncsTask(){
        synchronized (this){
            System.out.println("hello");
        }
    }
    public synchronized void syncTask(){
        System.out.println("Hello Again");
    }
}
