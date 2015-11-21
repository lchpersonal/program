package com.chengli.proxy.version003;

import com.chengli.proxy.base.Moveable;
import com.chengli.proxy.base.Tank;

/**
 * 生成任意实现的动态代理
 * Created by chengli on 2015/11/21.
 */
public class Main003 {
    public static void main(String[] args) throws Exception {
        Tank tank = new Tank();

        InvocationHandler h = new TimeInvocationHanlder();
        Moveable proxy = (Moveable) Proxy.newProxyInstance(tank, Moveable.class, h);
        proxy.move();
        System.exit(0);
    }
}
