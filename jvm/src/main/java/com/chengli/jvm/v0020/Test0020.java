package com.chengli.jvm.v0020;

import java.util.Random;

/**
 * Created by chengli on 2015/11/29.
 */

class FinalTest1 {
    /**
     * 编译时常量，访问它不会初始化这个类
     */
    public static final int x = 100 / 2;

    static {
        System.out.println("final block ~~~");
    }
}

class FinalTest2 {
    /**
     * 运行时常量，访问它会初始化这个类
     */
    public static final int x = new Random().nextInt(100);

    static {
        System.out.println("final block ~~~");
    }
}

public class Test0020 {
    public static void main(String[] args) {
        System.out.println(FinalTest1.x);
        System.out.println(FinalTest2.x);
    }
}
