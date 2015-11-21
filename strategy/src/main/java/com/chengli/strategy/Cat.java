package com.chengli.strategy;

/**
 * Created by chengli on 2015/11/21.
 */
public class Cat implements Comparable {

    private int height;
    private Comparator comparator = new CatCompartor();

    public Cat(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int compareTo(Object o) {
        return comparator.compare(this, o);
    }
}
