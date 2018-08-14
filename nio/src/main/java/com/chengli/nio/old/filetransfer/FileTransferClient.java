package com.chengli.nio.old.filetransfer;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by chengli on 2016/10/24.
 */
public class FileTransferClient {

    private static FileInputStream fileInputStream;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws IOException {
        SocketChannel sc = SocketChannel.open();
        sc.connect(new InetSocketAddress(8888));
        fileInputStream = new FileInputStream("E:\\JNative-1.3.2.zip");
        FileChannel fileChannel = fileInputStream.getChannel();
        while (fileChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            sc.write(byteBuffer);
            byteBuffer.clear();
        }
        fileChannel.close();
        fileInputStream.close();
        sc.close();
    }
}
