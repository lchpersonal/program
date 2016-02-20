package com.chengli.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args : -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * 限制堆大小为20M
 * 异常：
 * java.lang.OutOfMemoryError: Java heap space
 * Created by chengli on 2016/2/20.
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
