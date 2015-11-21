package com.chengli.proxy.version001;

import com.chengli.proxy.base.Tank;

/**
 * TankTimeProxy 是 Tank的代理类，打印坦克运行开始和结束时间
 * Created by chengli on 2015/11/21.
 */
public class Main {
    public static void main(String[] args) {
        Tank tank = new Tank();
        TankTimeProxy tankTimeProxy = new TankTimeProxy(tank);
        tankTimeProxy.move();
    }
}
