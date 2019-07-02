package com.wangzhou.thread;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/14
 * Time:15:01
 **/
public class SingletonExample5 {
    private SingletonExample5() {
    }

    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
