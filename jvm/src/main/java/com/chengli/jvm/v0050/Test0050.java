package com.chengli.jvm.v0050;

/**
 * Created by chengli on 2015/11/29.
 * <p>
 * 只有当程序访问的静态变量或静态方法确实在当前类或接口中定义时，
 * 才可以认为是对类的主动使用
 */
public class Test0050 {

    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}

class Parent {
    static int a = 3;

    static {
        System.out.println("parent static block");
    }
}

class Child extends Parent {

    static {
        System.out.println("child static block");
    }
}