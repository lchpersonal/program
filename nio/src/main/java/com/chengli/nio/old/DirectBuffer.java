package com.chengli.nio.old;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 直接缓冲区
 *
 * Created by chengli on 2016/9/20.
 */
public class DirectBuffer {

    public static void main(String[] args) throws IOException {
        File file = new File("c:/readFromFile.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        //调用allocateDirect方法分配buffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
    }
}
