package com.chengli.java8.lambda.innerinterface;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author: chengli
 * @Date: 2018/8/11 12:13
 * <p>
 * 1：消费型接口：
 * @see java.util.function.Consumer
 * 2：供给型接口：
 * @see java.util.function.Supplier
 * 3: 功能性接口：
 * @see java.util.function.Function
 * 4：断言型接口：
 * @see java.util.function.Predicate
 */
public class InnerInterface {


    @Test
    public void test() {
        /**消费型接口测试*/
        System.out.println("消费型接口测试======================");
        costVigor(100, (viger) -> System.out.println("扣除了" + viger + "精力"));

        /**供给型接口测试*/
        System.out.println("供给型接口测试======================");
        System.out.println(String.format("产生了%s精力", createVigor(() -> 100)));

        /**功能型接口测试*/
        System.out.println("功能型接口测试======================");
        int rmb = 100;
        System.out.println(String.format("花%s钱，买了%s元宝", rmb, recharge(rmb, (money) -> 1000)));

        /**断言型接口测试*/
        System.out.println("断言型接口测试======================");
        int score = 100;
        System.out.println(String.format("当前积分为%s,会员属性：%s", score, memberTest(score, t -> t > 50 ? true : false)));

    }

    /**
     * 扣除精力
     */
    public void costVigor(int corn, Consumer<Integer> con) {
        con.accept(corn);
    }

    /**
     * 产生精力
     */
    public int createVigor(Supplier<Integer> sup) {
        return sup.get();
    }

    /**
     * 充值人民币买元宝
     *
     * @return
     */
    public int recharge(int rmb, Function<Integer, Integer> func) {
        return func.apply(rmb);
    }

    /**
     * 根据积分，判断是否是会员
     *
     * @return
     */
    public boolean memberTest(int score, Predicate<Integer> pre) {
        return pre.test(score);
    }
}
