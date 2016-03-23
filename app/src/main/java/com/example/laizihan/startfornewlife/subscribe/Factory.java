package com.example.laizihan.startfornewlife.subscribe;

import android.view.View;

/**
 * Created by laizihan on 16/3/17.
 */

interface Service{
    void doSomeWork();


}

interface ServiceManager{
    Service generate();
}


class NetworkService implements Service{

    @Override
    public void doSomeWork() {

    }
}

class DefaultServiceManager implements ServiceManager{
    @Override
    public Service generate() {
        return new NetworkService();
    }
}


public class Factory {

    public static void main(String[] args){

        ServiceManager serviceManager = new DefaultServiceManager();
        Service service = serviceManager.generate();
        service.doSomeWork();
        View view;
    }




}
