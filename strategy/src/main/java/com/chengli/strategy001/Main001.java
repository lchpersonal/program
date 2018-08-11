package com.chengli.strategy001;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: chengli
 * @Date: 2018/8/11 11:02
 */
public class Main001 {


    @Test
    public void test001() {
        Dog[] dogArr = new Dog[]{
                new Dog(1, "huang"),
                new Dog(2, "hei"),
                new Dog(7, "bai"),
                new Dog(4, "baihei")};
        List<Dog> dogs = Arrays.asList(dogArr);
        sort(dogs, (a, b) -> {
            if (a.getAge() > b.getAge()) {
                return 1;
            } else if (a.getAge() < b.getAge()) {
                return -1;
            }
            return 0;
        });
        System.out.println(dogs);
    }

    private <T> void sort(List<T> list, Compator001<T> compator001) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (compator001.compare(list.get(j), list.get(j + 1)) > 0) {
                    T t = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, t);
                }
            }
        }
    }
}
