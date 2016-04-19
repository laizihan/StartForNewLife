package com.example.laizihan.startfornewlife.subscribe;

/**
 * 创建时间：2016年04月01日 上午9:24
 * 创建人：赖梓瀚
 * 类名：InterfaceTest
 * 用途：
 */

interface Scrolling {
    int compute();
}

class FuckView implements Scrolling {

    @Override
    public int compute() {
        return 0;
    }
}


public class InterfaceTest {

    public static void onScroll(Scrolling scrolling){
        scrolling.compute();
    }

    public static void main(String[] args){

        onScroll(new FuckView());
    }

}
