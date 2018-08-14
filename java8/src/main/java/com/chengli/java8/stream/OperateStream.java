package com.chengli.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: chengli
 * @Date: 2018/8/12 9:41
 * <p>
 * <pre>
 * Stream流的中间操作
 *    筛选与切片：
 *       filter：接收 Lambda ， 从流中排除某些元素。
 *       limit：截断流，使其元素不超过给定数量。
 *       skip(n)：跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
 *       distinct：筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 * @see com.chengli.java8.stream.OperateStream#test
 *    映射：
 *       map：接收一个函数作为参数，该函数会被应用到每个元素，并将其映射成一个新的元素
 *       flatmap：接收一个函数作为参数，将流中的每一个值都换成另一个流，然后将所有流接成一个流
 *       ......
 * @see com.chengli.java8.stream.OperateStream#test2
 * @see com.chengli.java8.stream.OperateStream#test3
 *    排序：
 *       sorted() -- 自然排序（实现了Comparable接口的）
 *       sorted(Comparator com) -- 定制排序
 * </pre>
 * 流的中间操作返回的是一个新流，原始流没有改变
 */
public class OperateStream {

    List<User> userList = new ArrayList() {{
        add(new User("张三", 20, 5050, 1));
        add(new User("李四", 30, 5150, 2));
        add(new User("王五", 25, 2050, 1));
        add(new User("赵六", 45, 1050, 2));
    }};

    /**
     * 筛选与切片
     */
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(new Integer[]{22, 34, 52, 11, 67, 11, 9});
        /**filter取出所有偶数*/
        list.stream().filter(x -> x % 2 == 0)
                .forEach(System.out::println);
        System.out.println("-------------------------------");
        /**skip，limit截取第2到4个元素*/
        list.stream().skip(1).
                limit(3).forEach(System.out::println);
        System.out.println("-------------------------------");
        /**distinct去重*/
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射: map
     */
    @Test
    public void test2() {
        /**取出所有人的姓名*/
        userList.stream().map(User::getName).forEach(System.out::println);
    }

    /**
     * 映射：flatmap
     */
    @Test
    public void test3() {
        String[] arr = new String[]{"aa", "bc", "dg", "es"};
        /**
         * 取出所有的字母
         */
        Arrays.stream(arr).flatMap(x -> getChar(x)).forEach(System.out::println);
    }

    private Stream<Character> getChar(String str) {
        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            characterList.add(str.charAt(i));
        }
        return characterList.stream();
    }

    /**
     * 排序
     */
    @Test
    public void test5() {
        /**自然排序*/
        String[] arr = new String[]{"aa", "bc", "dg", "ff", "es"};
        Arrays.stream(arr).sorted().forEach(System.out::println);
        /**定制排序，userlist 根据年龄排序*/

        userList.stream().
                sorted(Comparator.comparingInt(User::getAge))
                .forEach(System.out::println);

    }

}
