package com.chengli.jvm.classloader.v0060;

/**
 * Created by chengli on 2015/11/29.
 * <p>
 * 调用ClassLoader的loadClass方法加载一个类，并不是对类的主动使用
 */


public class Test0060 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("com.chengli.jvm.classloader.v0060.CL");
        System.out.println("------------------------------");
        clazz = Class.forName("com.chengli.jvm.classloader.v0060.CL");
    }
}

class CL {

    static {
        System.out.println("class CL static block");
    }
}



