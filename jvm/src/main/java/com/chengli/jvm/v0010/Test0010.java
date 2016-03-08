package com.chengli.jvm.v0010;

/**
 * 类的加载、连接、初始化
 * Created by chengli on 2015/11/29.
 * <pre>
 * 1.加载
 * 2.连接：
 *      ① 验证 、② 准备、③ 解析
 * 3.初始化
 * </pre>
 * <p>
 * 类或接口在首次主动使用的时候才会初始化他们
 * <p>
 * <pre>
 * 主动使用：
 *      1.创建类的实例
 *      2.访问某个类或接口的静态变量、或者是为某个静态变量赋值
 *      3.调用类的静态方法
 *      4.反射，如：Class.forName("com.chengli.jvm.xxx")
 *      5.初始化一个类的子类
 *      6。Java虚拟机启动时被标注为启动类的类
 * </pre>
 * <p>
 * <pre>
 * ps: jvm初始化一个类的时候要求其父类已经被初始化，但是这个规则不适应与接口：
 *      ①：在初始化一个类的时候，并不会初始化其实现的接口
 *      ②：在初始化一个接口的时候，并不会初始化其父接口
 * 只有在明确使用一个接口的静态变量时，才会初始化该接口。
 * </pre>
 */

class Singleton1 {
    private static Singleton1 singleton = new Singleton1();
    public static int counter1;
    public static int counter2 = 0;

    public Singleton1() {
        counter1++;
        counter2++;
    }

    public static Singleton1 getInstance() {
        return singleton;
    }
}

class Singleton2 {
    public static int counter1;
    public static int counter2 = 0;
    private static Singleton2 singleton = new Singleton2();

    public Singleton2() {
        counter1++;
        counter2++;
    }

    public static Singleton2 getInstance() {
        return singleton;
    }
}

public class Test0010 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println(singleton1.counter1);
        System.out.println(singleton1.counter2);
        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println(singleton2.counter1);
        System.out.println(singleton2.counter2);
    }
}
