package com.chengli.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by chengli on 2016/1/28.
 */
public class FlatMapTest {

    public static void main(String[] args) {
        Stream<List<Integer>> inputStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        Stream<Integer> outputStream = inputStream.flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);
    }
}
