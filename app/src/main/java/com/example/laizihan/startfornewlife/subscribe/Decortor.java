package com.example.laizihan.startfornewlife.subscribe;

import android.os.MemoryFile;
import android.os.Process;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by laizihan on 16/3/15.
 */

interface Conponent {
    void doSome();
}


class ConcreteConponent implements Conponent {


    @Override
    public void doSome() {
        System.out.println("this is the base conponent");
    }
}


class DecortorBase implements Conponent {
    private Conponent conponent;

    {
        MemoryFile memoryFile = null;
        Process p = new Process();
        if (memoryFile != null) {
            memoryFile.getInputStream();
        }

    }

    public DecortorBase(Conponent conponent) {
        this.conponent = conponent;
    }

    @Override
    public void doSome() {
        conponent.doSome();
    }
}

class DecortorSub extends DecortorBase {

    public DecortorSub(Conponent conponent) {
        super(conponent);
    }

    @Override
    public void doSome() {
        super.doSome();
        doAnotherThing();
    }

    public void doAnotherThing() {
        System.out.println("this is the sub conponent");
    }


}





public class Decortor {

    public static void main(String[] args) {
        Conponent conponent = new DecortorSub(new DecortorBase(new ConcreteConponent()));
        conponent.doSome();


    }
}
