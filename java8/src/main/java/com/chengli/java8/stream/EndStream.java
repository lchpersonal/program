package com.chengli.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: chengli
 * @Date: 2018/8/12 11:09
 * <p>
 * Stream终止操作
 * 1. allMatch -- 检查所有元素都匹配
 * 2. anyMatch -- 检查至少有一个元素匹配
 * 3. noneMatch -- 检查是否所有元素都不匹配
 * 4. findFirst -- 返回第一个元素
 * 5. findAny -- 返回当前流中的任意元素
 * 6. count -- 返回流中元素个数
 * 7. max -- 返回流中元素的最大值
 * 8. min -- 返回流中元素的最小值
 * @see com.chengli.java8.stream.EndStream#test
 * <p>
 * 9. collect -- 按照指定的方式收集流中的元素(Collector中定义了很多收集方式)
 * 10. reduce(T identity,BinaryOperator) / reduce(BinaryOperator) -- 将流中的值，按照一定的规则
 *
 * 11.分组
 * 12：分区/切片
 * 13：统计
 * 反复结合起来，得到最终一个值
 */
public class EndStream {

    List<User> userList = new ArrayList() {{
        add(new User("张三", 20, 5050, 1));
        add(new User("李四", 30, 5150, 2));
        add(new User("王五", 25, 2050, 1));
        add(new User("赵六", 45, 1050, 2));
    }};

    @Test
    public void test() {
        /**判断userList中是否都是男人： allMatch*/
        System.out.println("===============是否全部都为男性==============");
        System.out.println(userList.stream().allMatch(x -> x.getSex() == 1));
        /**判断是否含有男性： anyMatch*/
        System.out.println("===============是否含有男性==============");
        System.out.println(userList.stream().anyMatch(x -> x.getSex() == 1));
        /**判断没有女人： noneMatch*/
        System.out.println("===============是否含有男性==============");
        System.out.println(userList.stream().noneMatch(x -> x.getSex() == 2));

        /**取出列表中第一个人： findFirst*/
        System.out.println("============列表中第一个人=================");
        System.out.println(userList.stream().findFirst());
        /**取出列表中随机一人： findAny*/
        System.out.println("============列表中随机一人=================");
        System.out.println(userList.stream().findAny());
        /**元素个数：count */
        System.out.println("============列表中元素个数=================");
        System.out.println(userList.stream().count());
        /**取出年龄最小的*/
        System.out.println("============列表中年龄最小的=================");
        System.out.println(userList.stream().min(Comparator.comparingInt(User::getAge)));
        /**取出年龄最大的*/
        System.out.println("============列表中年龄最大的=================");
        System.out.println(userList.stream().max(Comparator.comparingInt(User::getAge)));

        /**取出所有人的名字，并返回一个list*/
        System.out.println("==============所有人名字===============");
        List<String> collect = userList.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(collect);

        /**求工资平均值*/
        System.out.println("================工资平均值================");
        Double collect1 = userList.stream().collect(Collectors.averagingDouble(User::getSalary));
        System.out.println(collect1);

        /**求工资总和*/
        System.out.println("================工资总和================");
        Double collect2 = userList.stream().collect(Collectors.summingDouble(User::getSalary));
        System.out.println(collect2);

        /**求所有人的年龄总和: reduce*/
        System.out.println("==================年龄总和=================");
        Optional<Integer> reduce = userList.stream().map(User::getAge).reduce((x, y) -> x + y);
        System.out.println("年龄总和reduce："+reduce.get());

        /**求所有人的年龄总和: collect*/
        System.out.println("==================年龄总和=================");
        Double collect3 = userList.stream().collect(Collectors.summingDouble(User::getAge));
        System.out.println("年龄总和 collect："+collect3);

        /**
         * 根据性别分组
         */
        System.out.println("==================根据性别分组==================");
        Map<Integer, List<User>> collect4 = userList.stream().collect(Collectors.groupingBy(User::getSex));
        System.out.println(collect4);

        /**
         * 分区
         */
        System.out.println("===================根据是否为男性分区===================");
        Map<Boolean, List<User>> collect5 = userList.stream().collect(Collectors.partitioningBy(x -> x.getSex() == 1));
        System.out.println(collect5);

        /**
         * 获取统计信息
         */
        System.out.println("=================获取统计信息======================");
        DoubleSummaryStatistics collect6 = userList.stream().collect(Collectors.summarizingDouble(User::getSalary));
        System.out.println(collect6);
    }
}
