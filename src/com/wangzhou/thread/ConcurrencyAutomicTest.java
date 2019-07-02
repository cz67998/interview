package com.wangzhou.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/6/17
 * Time:10:19
 **/
public class ConcurrencyAutomicTest {
   private static  int clientTotal=5000;
   private static int threadTotal=200;
   private static AtomicInteger atomicInteger=new AtomicInteger(0);
   public static void main(String[] args) throws InterruptedException {
     final Semaphore semaphore=new Semaphore(threadTotal);
     final CountDownLatch countDownLatch=new CountDownLatch(clientTotal);
     ExecutorService executorService=Executors.newCachedThreadPool();
       for (int i = 0; i < clientTotal; i++) {
           executorService.execute(()->{
               try {
                   semaphore.acquire();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               add();
               semaphore.release();
               countDownLatch.countDown();
           });
       }


     countDownLatch.await();
     executorService.shutdown();
   }

    private static void add() {
        atomicInteger.incrementAndGet();
    }
}
