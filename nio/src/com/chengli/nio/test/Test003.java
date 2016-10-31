package com.chengli.nio.test;

import java.nio.ByteBuffer;

/**
 * Created by chengli on 2016/10/27.
 */
public class Test003 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("Hello".getBytes());
        System.out.println(buffer.limit());


        byte[] dst = new byte[20];
        //假如 buffer中的数据不足以填满dst，那么会抛异常。
        buffer.get(dst);
    }
}
