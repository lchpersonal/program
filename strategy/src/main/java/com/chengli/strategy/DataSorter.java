package com.chengli.strategy;

/**
 * 对任意类型的数组进行排序
 * Created by chengli on 2015/11/21.
 */
public class DataSorter {

    public static void sort(Comparable[] datas) {
        for (int i = 0; i < datas.length - 1; i++) {
            for (int j = 0; j < datas.length - i - 1; j++) {
                if (datas[j].compareTo(datas[j + 1]) > 0) {
                    swap(datas, j, j + 1);
                }
            }
        }
    }

    private static void swap(Comparable[] datas, int i, int j) {
        Comparable temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }
}
