package com.wangzhou.reflect;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:10:57
 **/
public class Finalization {

    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalization");
        finalization=this;
    }
    public static void main(String[] args) throws InterruptedException {
    Finalization f=new Finalization();
        System.out.println("first print:"+f);
        f=null;
        //gc会触发finalize
        System.gc();
        //等待gc完成
        Thread.sleep(3000);
        System.out.println("second print:"+f);
        System.out.println(f.finalization);




    }
}
