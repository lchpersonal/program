package com.chengli.strategy;

/**
 * Created by chengli on 2015/11/21.
 */
public class Main {

    public static void main(String[] args) {
        Cat[] cats = new Cat[]{new Cat(1), new Cat(5), new Cat(3)};
        DataSorter.sort(cats);
        print(cats);

    }

    private static void print(Cat[] cats) {
        for (int i = 0; i < cats.length; i++) {
            System.out.print(cats[i].getHeight() + "\t");
        }
    }
}
