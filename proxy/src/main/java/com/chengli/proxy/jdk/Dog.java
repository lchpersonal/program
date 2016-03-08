package com.chengli.proxy.jdk;

/**
 * Created by chengli on 2016/3/8.
 */
public class Dog implements  Moveable {

    @Override
    public void move() {
        System.out.println("dog is moving~ ");
    }
}
