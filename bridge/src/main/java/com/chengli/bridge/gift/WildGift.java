package com.chengli.bridge.gift;

/**
 * 狂野型的礼物
 * <p>
 * Created by chengli on 2015/11/22.
 */
public class WildGift extends Gift {

    public WildGift(GiftImpl giftImpl) {
        this.type = "狂野型的";
        this.giftImpl = giftImpl;
    }
}
