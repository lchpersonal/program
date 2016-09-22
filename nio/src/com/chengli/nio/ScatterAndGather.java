package com.chengli.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * helloworld.txt 中的内容：helloworld
 * <p>
 * Created by chengli on 2016/9/20.
 */
public class ScatterAndGather {
    public static void main(String[] args) throws IOException {
        scatter();
        gather();
    }

    private static void scatter() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("c:/helloworld.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer[] byteBuffers = new ByteBuffer[]{ByteBuffer.allocate(5), ByteBuffer.allocate(5)};
        channel.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            System.out.println();
        }
    }

    private static void gather() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("c:/gather.txt");
        ByteBuffer buffer1 = ByteBuffer.allocate(5);
        ByteBuffer buffer2 = ByteBuffer.allocate(5);
        buffer1.put("hello".getBytes());
        buffer2.put("world".getBytes());
        buffer1.flip();
        buffer2.flip();
        ByteBuffer[] byteBuffers = new ByteBuffer[]{buffer1, buffer2};
        fileOutputStream.getChannel().write(byteBuffers);
    }
}
