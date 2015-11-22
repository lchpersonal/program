package com.chengli.bridge.gift;

/**
 * Created by chengli on 2015/11/22.
 */
public abstract class Gift {
    protected String type;
    protected GiftImpl giftImpl;

    public String toString() {
        return this.type + this.giftImpl.toString();
    }
}
