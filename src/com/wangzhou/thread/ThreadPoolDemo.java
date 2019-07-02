package com.wangzhou.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:11:16
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException{
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<String> future=executorService.submit(new MyCallable());
        if(!future.isDone()){
            System.out.println("task has not finished,please wait");
        }
        try {
            System.out.println("task return:"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
