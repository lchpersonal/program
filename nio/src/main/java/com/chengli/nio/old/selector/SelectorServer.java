package com.chengli.nio.old.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chengli on 2016/9/21.
 */
public class SelectorServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc1 = buildServerSocket(8980);
        ServerSocketChannel ssc2 = buildServerSocket(8981);
        Selector selector = Selector.open();
        ssc1.register(selector, SelectionKey.OP_ACCEPT);
        ssc2.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            int num = selector.select();
            if (num > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                        doAccept(key, selector);
                    } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                        doRead(key);
                    }
                    iterator.remove();
                }
            }
            Thread.sleep(200);
        }
    }

    private static void doRead(SelectionKey key) throws IOException {
        if (key.isReadable()) {
            try {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);
                while (socketChannel.read(byteBuffer) != -1) {
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()) {
                        System.out.print((char) byteBuffer.get());
                    }
                    System.out.println();
                    byteBuffer.clear();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void doAccept(SelectionKey key, Selector selector) throws Exception {
        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = channel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    private static ServerSocketChannel buildServerSocket(int port) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
        ServerSocket serverSocket = ssc.socket();
        serverSocket.bind(new InetSocketAddress(port));
        return ssc;
    }

}
