package com.chengli.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chengli on 2016/1/27.
 */
public class FilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().filter(a -> a == "a").forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list1.stream().filter(a -> a % 2 == 0).forEach(System.out::print);
    }
}
