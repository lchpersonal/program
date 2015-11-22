package com.chengli.bridge.gift;

/**
 * 温暖型的礼物
 * <p>
 * Created by chengli on 2015/11/22.
 */
public class WarmGift extends Gift {

    public WarmGift(GiftImpl giftImpl) {
        this.type = "温暖型的";
        this.giftImpl = giftImpl;
    }

}
