package com.chengli.nio.old.filelock;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by chengli on 2016/9/20.
 */
public class FileLockTest2 {

    static String file = "c:/lock.txt";

    public static void main(String[] args) throws Exception {
        readFromFile(file);
    }

    private static void readFromFile(String fileName) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        FileChannel channel = raf.getChannel();
        FileLock lock = channel.lock();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }
        System.out.println();
        Thread.sleep(5000);
        lock.release();
    }
}
