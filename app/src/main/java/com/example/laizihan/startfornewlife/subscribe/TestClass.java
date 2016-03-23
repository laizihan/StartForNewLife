package com.example.laizihan.startfornewlife.subscribe;

import android.os.MemoryFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by laizihan on 16/3/6.
 */




class ContreaSubject implements Subject {

    MemoryFile memoryFile;

    List<Poster> mList = new ArrayList<>();
    private int i = 0;

    ContreaSubject() {
        try {
            memoryFile = new MemoryFile("",20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Poster poster) {
        mList.add(poster);
        notify("add:" + (++i));
    }

    @Override
    public void remove(Poster poster) {
        mList.remove(poster);
        notify("remove:" + (--i));

    }

    @Override
    public void notify(String s) {
        for (Poster poster : mList) {
            poster.update(s);
        }
    }
}


class Posternation implements Poster {
    private Subject subject;


    public Posternation(Subject subject) {
        this.subject = subject;
    }


    @Override
    public void update(String s) {
        System.out.println("s" + s);
    }
}


public class TestClass {


    public static void main(String[] args) {
        Subject subject = new ContreaSubject();
        Poster posternation = new Posternation(subject);
        Poster posternation1 = new Posternation(subject);
        subject.add(posternation);
        subject.add(posternation1);
    }
}
