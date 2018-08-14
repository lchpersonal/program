package com.chengli.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chengli
 * @Date: 2018/8/12 9:25
 *
 * <pre>
 * 创建stream
 * 1. Collection 提供了两个方法  stream() 与 parallelStream()
 * 2. 通过 Arrays 中的 stream() 获取一个数组流
 * 3. 通过 Stream 类中静态方法 of()
 * 4. 创建无限流
 *   a.迭代
 *   b.生成
 * </pre>
 */
public class CreateStream {

    @Test
    public void test() {
        /**
         *  Collection 提供了两个方法  stream() 与 parallelStream()
         */
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream = list.stream();
        Stream<Integer> parallelStream = list.parallelStream();
        /**
         * 通过 Arrays 中的 stream() 获取一个数组流
         */
        Integer[] arr = new Integer[3];
        Stream<Integer> stream1 = Arrays.stream(arr);
        /**
         * 3. 通过 Stream 类中静态方法 of()
         */
        Stream<Integer> stream2 = Stream.of(new Integer[]{1, 2, 3, 3});
        /**
         * 4. 创建无限流 ---- 迭代
         */
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        /**
         * 4. 创建无限流 ---- 生成
         */
        Stream<Double> generate = Stream.generate(Math::random);
    }

}
