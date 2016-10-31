package com.chengli.nio.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * java nio 内存映射文件效率对比测试,
 */
public class IOTest {
    static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws Exception {
        //文件大小：76.1 M, 这里用的是两个不同的文件
        read1("F:/nexus-2.11.4-01-bundle-1.zip");
        read2("F:/nexus-2.11.4-01-bundle.zip");
    }

    //通过内容映射文件的方式读取
    private static void read1(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        MappedByteBuffer buff = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        byte[] b = new byte[1024];
        int len = (int) file.length();
        long begin = System.currentTimeMillis();
        for (int offset = 0; offset < len; offset += 1024) {
            if (len - offset > BUFFER_SIZE) {
                buff.get(b);
            } else {
                buff.get(new byte[len - offset]);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time1 is:" + (end - begin));
    }


    //NIO普通方式读取
    private static void read2(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        long begin = System.currentTimeMillis();
        while (channel.read(buff) != -1) {
            buff.flip();
            buff.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("time2 is:" + (end - begin));
    }
}