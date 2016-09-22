package com.chengli.nio.filelock;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * FileLockTest1与FileLockTest2同时运行
 * <p>
 * 写了几个测试程序for tryLock/lock method，分成几种情况：
 * Case 1:  your java app lock file, then other software (e.g. notepad) can't modify and save the locked file
 * Case 2:  When another software (e.g. Excel) lock a file, if your java app try to lock it, will throw FileNotFoundException
 * Case 3: if you try to lock file  more than once in same thread or different thread, it will throw OverlappingFileLockException
 * Case 4: when one JVM is locking a file, if u try to call tryLock/Lock method in another JVM, tryLock method returns null immediately, lock method blocks until the previous JVM release lock.
 * <p>
 * Created by chengli on 2016/9/20.
 */
public class FileLockTest1 {

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
