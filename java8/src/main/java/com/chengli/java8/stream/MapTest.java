package com.chengli.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by chengli on 2016/1/27.
 */
public class MapTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c");
        list.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);


    }
}
