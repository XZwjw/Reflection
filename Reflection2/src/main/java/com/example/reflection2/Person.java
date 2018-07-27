package com.example.reflection2;


/**
 * Description:
 * Created by wangjiawang on 2018/7/27.
 * complete
 */

public class Person {
    private static final String TAG = "Person";
    String mName;

    public Person(String mName) {
        this.mName = mName;
    }

    private void sayHello(String friendName) {
        System.out.println(mName+ " say hello to "+friendName);
    }

    protected void showMyName() {
        System.out.println("My name is "+mName);
    }

    public void breathe() {
        System.out.println(" take breathe ");
    }
}
