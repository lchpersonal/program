package com.chengli.proxy.version002;

import com.chengli.proxy.base.Moveable;
import com.chengli.proxy.base.Tank;

/**
 * TankTimeProxy 是 Tank的代理类，打印坦克运行开始和结束时间,
 * 主要演示如何动态遍历代码，其中TankTimePorxy.java都是动态生成和编译的
 * Created by chengli on 2015/11/21.
 */
public class Main002 {
    public static void main(String[] args) throws Exception {
        Tank tank = new Tank();
        Moveable proxy = (Moveable) Proxy.newProxyInstance(tank);
        proxy.move();
        System.exit(0);
    }
}
