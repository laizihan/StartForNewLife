package com.example.laizihan.startfornewlife.javaTest;

import android.view.View;

/**
 * 创建时间：2016年04月01日 上午10:40
 * 创建人：赖梓瀚
 * 类名：GenericTest
 * 用途：
 *
 *
 *
 */

interface Data<T> {
    T get();

    void set(T t);
}

class DataSource<T> implements Data<T> {
    private T holder;

    public DataSource(T holder) {
        this.holder = holder;
    }

    @Override
    public T get() {
        return holder;
    }

    @Override
    public void set(T t) {
        this.holder = t;
    }
}

class DataSourceControl extends DataSource<String> {

    public DataSourceControl(String holder) {
        super(holder);
    }
}

class Generic<TT extends Data> implements Comparable<TT> {
    {
//        new DataSource<String>("laizihan");
    }

    TT d = (TT) new DataSourceControl("laizihan");


    public TT get() {
        System.out.println("" + d.get());
        return d;
    }

    public Generic<TT> set(TT tt) {
        this.d = tt;
        return this;
    }


    @Override
    public int compareTo(TT another) {

        return 0;
    }

    public <T> T select() {


        return null;


    }


}


interface Gender{
    String MALE = "男";
}


public class GenericTest {


    public static void main(String[] args) {
        String name = "laizihan";
        Integer integer = 23;
        if (false) {
            Data<String> holder = new DataSource<>(name);
            Data<Integer> integerData = new DataSource<>(integer);
            printGeneric(holder);
            printGeneric(integerData);
        }

        System.out.println("-------------");
//        Integer integer1 = new Generic<Data<Integer>>().get().get();
        System.out.println("-------------");
//        Data<Integer> integerData1 = new Generic<Data<Integer>>().set(new DataSource<Integer>(24)).get();
        new Generic<Data<Integer>>().get();


    }

    private static void printGeneric(Data<?> data) {
        System.out.println(data.get());
    }


}
