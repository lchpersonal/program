package com.chengli.bridge.gift;

/**
 * 具体的礼物：花
 * <p>
 * Created by chengli on 2015/11/22.
 */
public class Flower extends GiftImpl {


    public Flower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
