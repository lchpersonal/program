package com.chengli.nio.filetransfer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by chengli on 2016/10/24.
 */
public class FileTransferServer {
    private static FileOutputStream fileOutputStream;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private static final int port = 8888;
    private static Selector selector;
    private static ServerSocketChannel ssc;

    public static void main(String[] args) throws IOException {
        init();
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    doAccept();
                } else if (key.isReadable()) {
                    doRead(key);
                }
                iterator.remove();
            }
        }
    }

    /**
     * 参数初始化
     */
    private static void init() throws IOException {
        ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 执行读取操作
     */
    private static void doRead(SelectionKey key) throws IOException {
        System.out.println("read begining ~~~~~~~~~~~");
        SocketChannel channel = (SocketChannel) key.channel();
        int count;
        while ((count = channel.read(byteBuffer)) != -1) {
            if (count > 0) {
                byteBuffer.flip();
                fileOutputStream.getChannel().write(byteBuffer);
                fileOutputStream.flush();
                byteBuffer.clear();
            }
        }
        fileOutputStream.getChannel().close();
        fileOutputStream.close();
        channel.close();
    }


    private static void doAccept() throws IOException {
        System.out.println("accept begining ~~~~~~~~~~");
        SocketChannel sc = ssc.accept();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ);
        fileOutputStream = new FileOutputStream("C:/JNative-1.3.2.zip");
    }
}
