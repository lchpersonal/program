package com.chengli.jvm.volatiletest;

/**
 * Created by chengli on 2016/2/23.
 */
public class VolatileFeaturesExample {
    private volatile long vl = 0L;

    public void set(long l) {
        vl = l;
    }

    public void getAndIncrement() {
        vl++;    //复合（多个）volatile变量的读/写
    }


    public long get() {
        return vl;   //单个volatile变量的读
    }
}
