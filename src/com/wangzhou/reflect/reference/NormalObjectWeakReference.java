package com.wangzhou.reflect.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:12:31
 **/
public class NormalObjectWeakReference extends WeakReference<NormalObject>{
    public String name;
    public NormalObjectWeakReference(NormalObject normalObject,ReferenceQueue<NormalObject> rq){
       super(normalObject,rq);
       this.name=normalObject.name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing NormalObjectWeakReference"+name);
    }
}
