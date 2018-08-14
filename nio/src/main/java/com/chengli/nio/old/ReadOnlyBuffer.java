package com.chengli.nio.old;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by chengli on 2016/9/20.
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) throws IOException {
        File file = new File("c:/readFromFile.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel channel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2).asReadOnlyBuffer();
        //不能对只读buffer进行写操作。以下会报错
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
    }
}
