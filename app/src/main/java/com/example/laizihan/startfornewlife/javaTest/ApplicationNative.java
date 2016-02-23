package com.example.laizihan.startfornewlife.javaTest;

/**
 * Created by laizihan on 1/31/16.
 */
public abstract class ApplicationNative implements IApp {

    static IApp gDefault = new ApplicationProxy();



    static public IApp getDefault() {
        return gDefault;
    }

    static class ApplicationProxy implements IApp {
        @Override
        public void onTransc() {

        }
    }

}
