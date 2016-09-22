package com.chengli.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

/**
 * 写文件
 * Created by chengli on 2016/9/20.
 */
public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String msg = "write string to file use nio";
        FileOutputStream outputStream = new FileOutputStream("c:/writeToFile.txt");
        ByteChannel byteChannel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        byte[] msgs = msg.getBytes();
        for (int i = 0; i < msgs.length; i++) {
            buffer.put(msgs[i]);
        }
        buffer.flip();
        byteChannel.write(buffer);
    }
}
