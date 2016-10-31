package com.chengli.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by chengli on 2016/10/28.
 */
public class ServerSocketChannelTest {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ServerSocket ss = ssc.socket();
        ss.bind(new InetSocketAddress(8080));

        //此方式返回Socket对象，总是阻塞的方式运行
        ss.accept();
        //此方式返回SocketChannel对象，此方式支持非阻塞模式
        ssc.accept();

    }
}
