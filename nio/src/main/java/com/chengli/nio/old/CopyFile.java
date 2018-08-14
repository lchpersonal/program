package com.chengli.nio.old;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 拷贝文件
 *
 * Created by chengli on 2016/9/20.
 */
public class CopyFile {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("c:/src.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("c:/des.txt");
        FileChannel finChannel = fileInputStream.getChannel();
        FileChannel foutChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        while (finChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            foutChannel.write(byteBuffer);
            byteBuffer.clear();
        }
    }
}
