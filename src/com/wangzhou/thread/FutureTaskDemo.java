package com.wangzhou.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:11:00
 **/
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task=new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if(!task.isDone()){
            System.out.println("task has not finished,please wait");
        }
        System.out.println("task return:"+task.get());
    }
}
