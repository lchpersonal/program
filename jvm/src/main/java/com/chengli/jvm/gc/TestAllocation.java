package com.chengli.jvm.gc;

/**
 * 测试垃圾回收
 * VM Args  -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 说明：
 * -Xmn10m: 10M分配给新生代
 * -XX:SurvivorRatio=8 表示 Eden:Survivor:Survivor=8: 1: 1
 * <p>
 * Created by chengli on 2016/2/20.
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
