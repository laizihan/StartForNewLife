package com.example.laizihan.startfornewlife.javaTest;

/**
 * 创建时间：2016年07月14日 上午11:59
 * 创建人：赖梓瀚
 * 类名：InherenceTest
 * 用途：
 */



class Father{

    protected void say(){
        System.out.println("father say");
    }

}

class Child extends Father{
    @Override
    public void say() {
        super.say();
        System.out.println("child say");
    }
}

class GrandChild extends Child{

    @Override
    public void say() {
        super.say();
        System.out.println("grand child say");
    }
}


public class InherenceTest {


    public static void main(String[] args){
        Father f = new Father();
        f.say();
    }
}
