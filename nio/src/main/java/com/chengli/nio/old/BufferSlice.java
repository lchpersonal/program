package com.chengli.nio.old;

import java.nio.ByteBuffer;

/**
 * 缓冲区的切片
 *
 * Created by chengli on 2016/9/20.
 */
public class BufferSlice {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.position(3);
        byteBuffer.limit(7);
        ByteBuffer slice = byteBuffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            byte data = slice.get();
            data *= 11;
            slice.put(i, data);
        }

        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while(byteBuffer.hasRemaining()){
            System.out.println((int)byteBuffer.get());
        }
    }

}
