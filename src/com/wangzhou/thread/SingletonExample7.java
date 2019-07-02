package com.wangzhou.thread;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/14
 * Time:15:12
 **/
public class SingletonExample7 {
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance() {
        return Singleton.INSTANCE.getSingletonExample7();
    }

    private enum Singleton {
        INSTANCE;
        private SingletonExample7 singletonExample7;
        Singleton(){
            singletonExample7=new SingletonExample7();  
        }

        public SingletonExample7 getSingletonExample7() {
            return singletonExample7;
        }
    }
}
