package com.wangzhou.reflect.reference;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:12:31
 **/
public class NormalObject {
    public String name;
    public NormalObject(String name){
        this.name=name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing object"+name);
    }
}
