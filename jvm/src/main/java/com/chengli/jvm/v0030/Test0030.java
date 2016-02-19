package com.chengli.jvm.v0030;

/**
 * Created by chengli on 2015/11/29.
 */
public class Test0030 {

    static {
        System.out.println("main static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent{
    static int a = 3;

    static {
        System.out.println("parent static block");
    }
}

class Child extends  Parent{
    static int b = 4;

    static {
        System.out.println("child static block");
    }
}