package com.chengli.nio.old.test;

import java.nio.ByteBuffer;

/**
 * Created by chengli on 2016/10/27.
 * <p>
 * buffer.clear() 方法测试
 */
public class Test002 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put("Hello".getBytes());
        System.out.println("position: " + buffer.position());

        //清空buffer，实际上并未清空里面的数据
        buffer.clear();

        buffer.put("Hell".getBytes());
        System.out.println("new1 position: " + buffer.position());
        //设置position为5
        buffer.limit(5);

        System.out.println(new String(buffer.array()));

    }
}
