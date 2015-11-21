package com.chengli.strategy;

/**
 * 定义猫根据高度的比较
 * Created by chengli on 2015/11/21.
 */
public class CatCompartor implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Cat cat1 = (Cat) o1;
        Cat cat2 = (Cat) o2;
        if (cat1.getHeight() > cat2.getHeight()) {
            return 1;
        } else if (cat1.getHeight() == cat2.getHeight()) {
            return 0;
        }
        return -1;
    }
}
