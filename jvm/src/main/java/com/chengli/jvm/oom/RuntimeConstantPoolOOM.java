package com.chengli.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池溢出
 * <p>
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * java8 不支持此参数
 * java8 不支持此参数
 * java8 不支持此参数
 * <p>
 * <pre>
 * 异常：
 *      java.lang.OutOfMemoryError: PermGen space
 * </pre>
 * Created by chengli on 2016/2/20.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
