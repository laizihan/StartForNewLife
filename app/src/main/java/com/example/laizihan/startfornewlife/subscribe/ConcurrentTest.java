package com.example.laizihan.startfornewlife.subscribe;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by laizihan on 16/3/22.
 */

class Thread1 implements Runnable {

    CountDownLatch countDownLatch;

    public Thread1(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread1 excute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}

class Thread2 implements Runnable {

    CountDownLatch countDownLatch;

    public Thread2(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread2 excute");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}

class Thread3 implements Runnable {

    CountDownLatch countDownLatch;

    public Thread3(CountDownLatch latch) {
        this.countDownLatch = latch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("线程1，2搞定了，现在线程3搞了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Writer implements Runnable {

    CyclicBarrier cyclicBarrier;
    int time;

    public Writer(CyclicBarrier cyclicBarrier, int time) {
        this.cyclicBarrier = cyclicBarrier;
        this.time = time;
    }


    @Override
    public void run() {
        try {
            System.out.println("当前线程：" + Thread.currentThread().getName() + " 正在写入");
            Thread.sleep(1000 * Math.abs(time));

            cyclicBarrier.await();

        } catch (BrokenBarrierException e) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


public class ConcurrentTest {

    public static void main(String args[]) {

   /*     CountDownLatch countDownLatch = new CountDownLatch(2);
        Runnable thread1 = new Thread1(countDownLatch);
        Runnable thread2 = new Thread2(countDownLatch);
        Runnable thread3 = new Thread3(countDownLatch);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);

*/

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程：" + Thread.currentThread().getName() + " 完成写入了！！！我们搞一个");
            }
        });
//        ExecutorService executorService = Executors.newCachedThreadPool();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Writer writer = new Writer(cyclicBarrier, i);
//            executorService.execute(writer);
            new Thread(writer).start();
        }


    }
}
