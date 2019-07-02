package com.wangzhou.thread;

import java.util.concurrent.Callable;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/13
 * Time:10:49
 **/
public class MyCallable  implements Callable<String>{
    private  String value;
    @Override
    public String call() throws Exception {
        String value="test";
        Thread.sleep(5000);
        return value;
    }
}
