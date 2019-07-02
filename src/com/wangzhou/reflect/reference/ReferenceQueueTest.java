package com.wangzhou.reflect.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/12
 * Time:13:26
 **/
public class ReferenceQueueTest {
    private static ReferenceQueue<NormalObject> rq = new ReferenceQueue<>();

    private static void checkQueue() {
        Reference<NormalObject> ref = null;
        while ((ref = (Reference<NormalObject>) rq.poll()) != null) {
            if (ref != null) {
                System.out.println("In Queue" + ((NormalObjectWeakReference) (ref)).name);
                System.out.println("reference object" + ref.get());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<WeakReference<NormalObject>> weakReferenceList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            weakReferenceList.add(new NormalObjectWeakReference(new NormalObject("weak" + i), rq));
            System.out.println("Create weak" + weakReferenceList.get(i));
        }
        System.out.println("first time");
        checkQueue();
        System.gc();

        Thread.sleep(10000);
        System.out.println("second time");
        checkQueue();

//        Integer i;
//        if((i=1)!=null){
//            System.out.println(i);
//        }
    }
}
