package com.example.laizihan.startfornewlife.subscribe;

/**
 * 创建时间：2016年03月30日 下午6:05
 * 创建人：赖梓瀚
 * 类名：AbstratModel
 * 用途：
 */
abstract class BaseActivity {
    private static int COUNT = 0;

    public BaseActivity() {
        ++COUNT;
    }

    abstract void onCreate();

    int getCount() {
        return COUNT;
    }
}


class A_Activity extends BaseActivity {

    @Override
    void onCreate() {
        System.out.println("已生成对象个数" + getCount());
    }


}


class B_Activity extends BaseActivity {

    @Override
    void onCreate() {
        System.out.println("已生成对象个数" + getCount());
    }
}


class Aa_Activity extends A_Activity {

}

public class AbstratModel {


    public static void main(String[] args) {
        new A_Activity().onCreate();
        new B_Activity().onCreate();
        new Aa_Activity().onCreate();

    }


}
