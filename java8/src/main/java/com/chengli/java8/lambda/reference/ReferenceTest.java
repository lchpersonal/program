package com.chengli.java8.lambda.reference;

import org.junit.Test;

import java.util.function.*;

/**
 * @Author: chengli
 * @Date: 2018/8/11 14:01
 * <p>
 * <p>
 * lambda表达式中方法的引用，主要有以下几种形式：
 * 一、
 * 1. 实例::实例方法名
 * 2. 类::静态方法
 * 3. 类::实例方法
 * 注意：
 * 引用的方法的参数和返回值类型，必须和接口方法的参数类型和返回类型一致才能使用方法引用。
 * 二、构造器引用
 * 类::new1
 * 三、数组的引用
 * 类[]::new1
 */
public class ReferenceTest {


    /**
     * 实例::实例方法名
     */
    @Test
    public void test001() {
        /**原始lambda表达式*/
        Consumer<Integer> consumer = x -> System.out.println(String.format("消费了%s元", x));
        consumer.accept(100);


        /**改为方法引用后，System.out其实是一个PrintStream对象*/
        Consumer<Integer> consumer1 = System.out::print;
        consumer1.accept(100);
    }

    /**
     * 类::静态方法
     */
    @Test
    public void test002() {

        /** String转int */
        Function<String, Integer> func1 = (x) -> Integer.valueOf(x);
        System.out.println(func1.apply("10"));

        Function<String, Integer> func2 = Integer::valueOf;
        System.out.println(func2.apply("20"));
    }

    /**
     * 类::实例方法
     * <p>
     * 判断两个字符串是否相等
     */
    @Test
    public void test003() {
        BiPredicate<String, String> bp1 = (x, y) -> x.equals(y);
        System.out.println(bp1.test("a", "b"));

        /**要改成这种形式，必须满足类似这种格式：(x, y) -> x.equals(y)，多个参数，
         * 其中一个参数调用方法，equals是参数实例内部的方法
         * */
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("cc", "cc"));
    }


    /**
     * 类::new1
     */
    @Test
    public void test004() {
        Supplier<Object> sup1 = () -> new Object();
        System.out.println(sup1.get());

        Supplier<Object> sup2 = Object::new;
        System.out.println(sup2.get());
    }

    /**
     * 数组引用
     * 类[]::new1
     */
    @Test
    public void test005() {
        Function<Integer, String[]> func1 = (x) -> new String[x];
        System.out.println(func1.apply(10).length);

        /**
         * new1 String时必须指定数组的长度，相当于是参数，所以，接口方法也要有一个参数才行。如果这里用Supplier接口就不行
         */
        Function<Integer, String[]> func2 = String[]::new;
        System.out.println(func2.apply(20).length);

    }
}
