package com.chengli.proxy.version001;

import com.chengli.proxy.base.Moveable;

/**
 * Tank运行时间的代理类（硬编码形式）
 * Created by chengli on 2015/11/21.
 */
class TankTimeProxy implements Moveable {

    /*被代理的对象*/
    private Moveable moveable;

    public TankTimeProxy(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public void move() {
        System.out.println("beginTime:" + System.currentTimeMillis());
        moveable.move();
        System.out.println("endTime:" + System.currentTimeMillis());
    }
}
