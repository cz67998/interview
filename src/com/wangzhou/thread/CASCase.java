package com.wangzhou.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/14
 * Time:15:27
 **/
public class CASCase {
    private volatile AtomicInteger value;
    public void add(){
        AtomicStampedReference atomicStampedReference=new AtomicStampedReference(value,0);
        value.incrementAndGet();
    }
}
