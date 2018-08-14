package com.chengli.nio.old.test;

import java.nio.CharBuffer;

/**
 * Created by chengli on 2016/10/27.
 * 通过wrap()创建一个buffer
 */
public class Test004 {
    public static void main(String[] args) {
        char[] arr = new char[20];
        // position = 5 ,limit = 20
        CharBuffer buffer = CharBuffer.wrap(arr, 5, 15);
        char[] content = {'h', 'e', 'l', 'l', 'o', ',', 'w', 'o', 'r', 'l', 'd'};
        buffer.put(content);

        if (buffer.hasArray()) {
            char[] bufferArr = buffer.array();
            for (int i = 0; i < bufferArr.length; i++) {
                System.out.print(i + ":" + bufferArr[i] + "\t ");
            }
        }

        // clear之后就可以使用数组的全部空间
        System.out.println("\r\nafter invoke the clear() method======");
        buffer.clear();
        buffer.put(content);
        if (buffer.hasArray()) {
            char[] bufferArr = buffer.array();
            for (int i = 0; i < bufferArr.length; i++) {
                System.out.print(i + ":" + bufferArr[i] + "\t");
            }
        }

    }
}
