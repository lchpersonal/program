package com.test.integer;

/**
 * Created by chengli on 2016/9/26.
 */
public class IntegerCacheTest {

    public static void main(String[] args) {
        test1(100);
        test2(100);
        test3(100);
        System.out.println("----------");
        test1(200);
        test2(200);
        test3(200);
        System.out.println("----------");
        test4(100);
        test5(100);
        test6(100);
        System.out.println("----------");
        test4(200);
        test5(200);
        test6(200);
    }

    private static void test6(int i) {
        Integer a = Integer.valueOf(i);
        System.out.println(a.equals(i) + " -- " + (a == i));
    }

    private static void test5(int i) {
        Integer a = Integer.valueOf(i);
        System.out.println(a.equals(i) + " -- " + (a == i));
    }

    private static void test4(int i) {
        Integer a = Integer.valueOf(i);
        System.out.println(a.equals(i) + " -- " + (a == i));
    }

    private static void test3(int i) {
        Integer a = Integer.valueOf(i);
        Integer b = Integer.valueOf(i);
        System.out.println(a.equals(b) + " -- " + (a == b));
    }

    private static void test2(int i) {
        Integer a = i;
        Integer b = i;
        System.out.println(a.equals(b) + " -- " + (a == b));
    }

    private static void test1(int i) {
        Integer a = new Integer(i);
        Integer b = new Integer(i);
        System.out.println(a.equals(b) + " -- " + (a == b));
    }
}
