package com.chengli.jvm.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengli on 2016/2/23.
 */
public class ToolUseTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(15000);
    }
}
