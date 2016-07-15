package com.example.laizihan.startfornewlife.subscribe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by laizihan on 16/3/20.
 */

class Storage {

    private List<String> mStorage = new LinkedList<>();


    public void add(int num) {
        synchronized (mStorage) {
            while (mStorage.size() + num > 100) {
                System.out.println("已生产:" + mStorage.size() + "搞不下了！！！");
                try {
                    mStorage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                mStorage.add("苹果");
            }
            System.out.println("已生产:" + mStorage.size());
            mStorage.notifyAll();

        }

    }

    public void remove(int num) {
        synchronized (mStorage) {
            while (mStorage.size() < 0) {

                System.out.println("已消费了:" + mStorage.size() + "不能再消费了");

                try {
                    mStorage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < num; i++) {
                mStorage.remove(i);
            }
            System.out.println("已消费了:" + mStorage.size());
            mStorage.notifyAll();

        }


    }


}


class Productor extends Thread {
    Storage storage;

    public Productor(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.add(20);
    }
}

class Consumer extends Thread {
    Storage storage;

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        storage.remove(20);
    }
}


public class ProductConsumer {

    public static void main(String[] args) {
        Storage storage = new Storage();


    }
}
