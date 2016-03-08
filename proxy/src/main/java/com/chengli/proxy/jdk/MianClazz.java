package com.chengli.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * Created by chengli on 2016/3/8.
 */
public class MianClazz {

    public static void main(String[] args) {
        Dog dog = new Dog();
        LogInvocationHandler handler = new LogInvocationHandler(dog);
        Moveable moveable = (Moveable) Proxy.newProxyInstance(dog.getClass().getClassLoader(), new Class[]{Moveable.class}, handler);
        moveable.move();
        moveable.bark();
    }
}
