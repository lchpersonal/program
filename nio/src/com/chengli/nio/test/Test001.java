package com.chengli.nio.test;

import java.nio.ByteBuffer;

/**
 * Created by chengli on 2016/10/27.
 *
 * java中默认字符使用unicode编码，占用16位
 */
public class Test001 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putChar('H').putChar('e').putChar('l').putChar('l').putChar('o');
        System.out.println("capacity:" + buffer.capacity());
        System.out.println("position:" + buffer.position());
        System.out.println("limit:" + buffer.limit());
    }
}
