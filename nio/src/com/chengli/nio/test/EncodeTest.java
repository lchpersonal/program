package com.chengli.nio.test;

import java.nio.ByteBuffer;

/**
 * Created by chengli on 2016/10/31.
 */
public class EncodeTest {
    public static void main(String[] args) {
        char a = 'a';
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        buffer.putChar(a);
        System.out.println(buffer.position());

        String b = String.valueOf(a);
        buffer.put(b.getBytes());
        System.out.println(buffer.position());

        String r = new String(buffer.array());
        System.out.println(r);
    }
}
