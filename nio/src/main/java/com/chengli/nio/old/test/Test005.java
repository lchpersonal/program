package com.chengli.nio.old.test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by chengli on 2016/10/27.
 * 视图缓冲区
 */
public class Test005 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.putChar('h').putChar('e').putChar('l').putChar('l').putChar('o');
        System.out.println("position: " + buffer.position());

        //根据剩余的容量创建一个视图缓冲区，以position为开始
        buffer.position(2);
        CharBuffer charBuffer = buffer.asCharBuffer();
        System.out.println("capacity: " + charBuffer.capacity());
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
    }
}
