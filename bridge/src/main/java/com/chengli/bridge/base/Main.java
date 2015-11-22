package com.chengli.bridge.base;

import com.chengli.bridge.gift.Flower;
import com.chengli.bridge.gift.Gift;
import com.chengli.bridge.gift.WarmGift;

/**
 * 桥接模式，男孩追女孩实例
 * <p>
 * 送礼物Gift，派生出来两个纬度的礼物：
 * ① 抽象的礼物：WarmGift 温暖型的礼物；WildGift 狂野型礼物
 * ② 具体的礼物：Flower 花；Ring 戒指
 * <p>
 * 假如 男孩要送女孩一个温暖型的花，或者狂野型的戒指该如何封装
 * <p>
 * Created by chengli on 2015/11/22.
 */
public class Main {

    public static void main(String[] args) {
        Boy boy = new Boy("男孩");
        Girl gril = new Girl("女孩");
        /*温软类型的花*/
        Gift gift = new WarmGift(new Flower("玫瑰"));
        boy.give(gift, gril);
    }
}
