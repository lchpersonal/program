package com.chengli.java8.stream;

import java.util.Optional;

/**
 * Created by chengli on 2016/1/28.
 */
public class OptioalTest {

    public static void main(String[] args) {
        String strA = " abcd ", strB = null;
        print(strA);
        print("");
        print(strB);
      /*  getLength(strA);
        getLength("");
        getLength(strB);*/

    }

    public static void print(String text) {
        // Java 8
        Optional.ofNullable(text).ifPresent(System.out::println);
        // Pre-Java 8
   /*     if (text != null) {
            System.out.println(text);
        }*/
    }

    public static int getLength(String text) {
        // Java 8
        return Optional.ofNullable(text).map(String::length).orElse(-1);
        // Pre-Java 8
        // return if (text != null) ? text.length() : -1;
    }

    ;
}
