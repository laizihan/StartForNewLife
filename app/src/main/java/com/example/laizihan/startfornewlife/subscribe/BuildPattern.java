package com.example.laizihan.startfornewlife.subscribe;

/**
 * 创建时间：2016年04月01日 下午3:08
 * 创建人：赖梓瀚
 * 类名：BuildPattern
 * 用途：
 */

class DialogInterface {
    String name;
    int age;

    public DialogInterface(DialogBuilder builder) {
        this.name = builder.getBuildName();
        this.age = builder.getBuildAge();
    }


}

class DialogBuilder {

    private String buildName;
    private int buildAge;


    public DialogBuilder setName(String name) {
        this.buildName = name;
        return this;
    }

    public DialogBuilder setAge(int age) {
        this.buildAge = age;
        return this;
    }

    public DialogInterface build() {
//        return new DialogInterface(this);
        return new DialogInterface(this);
    }


    public int getBuildAge() {
        return buildAge;
    }

    public String getBuildName() {
        return buildName;
    }
}


public class BuildPattern {


    public static void main(String[] args) {
        DialogBuilder dialogBuilder = new DialogBuilder();
        dialogBuilder.setAge(12).setName("laizihan").build();
    }
}
