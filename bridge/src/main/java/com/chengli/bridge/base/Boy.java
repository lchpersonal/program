package com.chengli.bridge.base;

import com.chengli.bridge.gift.Gift;

/**
 * Created by chengli on 2015/11/22.
 */
public class Boy {
    private String name;

    public Boy(String name) {
        this.name = name;
    }

    public void give(Gift gift, Girl girl) {
        System.out.println(name + "送了" + girl.getName() + gift.toString());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
