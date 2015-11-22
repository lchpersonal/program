package com.chengli.bridge.gift;

/**
 * 具体的礼物：戒指
 * <p>
 * Created by chengli on 2015/11/22.
 */
public class Ring extends GiftImpl {

    public Ring(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
