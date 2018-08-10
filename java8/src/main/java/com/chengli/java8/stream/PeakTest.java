package com.chengli.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chengli on 2016/1/28.
 */
public class PeakTest {
    public static void main(String[] args) {
        /*peek 对每个元素执行操作并返回一个新的 Stream*/
        Stream.of("lesson1", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

    }
}
