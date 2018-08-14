package com.chengli.nio.old.selector;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by chengli on 2016/9/21.
 */
public class SelectorClient {
    public static void main(String[] args) throws Exception {
        doUseStream();
        doUseNio();
    }

    private static void doUseNio() throws IOException, InterruptedException {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(true);
        sc.connect(new InetSocketAddress(8981));
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put("world".getBytes());
        byteBuffer.flip();
        sc.write(byteBuffer);
        sc.close();
        Thread.sleep(1000);
    }

    private static void doUseStream() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8980));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        outputStream.flush();
        outputStream.close();
    }


}
