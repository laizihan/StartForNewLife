package com.example.laizihan.startfornewlife.subscribe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建时间：2016年05月24日 下午10:29
 * 创建人：赖梓瀚
 * 类名：MutipleThread
 * 用途：
 */


public class MutipleThread {


    public static synchronized void push(int num) {
        while (apple.size()  > 10) {
            System.out.println("框满了");
            try {
                apple.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已添加一个");

        apple.add("apple:" );
        apple.notifyAll();
    }


    public static synchronized void pop(int num) {

        while (apple.size() == 0) {
            System.out.println("没东西吃了");
            try {
                apple.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已消费一个");
        apple.remove();

        apple.notifyAll();

    }


    static class Productor implements Runnable {

        @Override
        public void run() {
            synchronized (apple) {
                push(20);
            }
        }
    }


    static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (apple) {
                pop(20);
            }
        }
    }


    private static MutipleThread ourInstance = new MutipleThread();

    public static MutipleThread getInstance() {
        return ourInstance;
    }

    private MutipleThread() {
    }

    private static LinkedList<String> apple = new LinkedList<>();


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            String a= "abcd";

            new Thread(new Productor()).start();
            new Thread(new Consumer()).start();
        }
    }

}
