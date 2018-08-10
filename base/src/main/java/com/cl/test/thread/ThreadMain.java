package com.cl.test.thread;

/**
 * @Author: chengli
 * @Date: 2018/8/8 10:12
 * 用多线程模拟生产者消费者问题：
 * @see com.cl.test.thread.Consumer 消费者
 * @see com.cl.test.thread.Producer 生产者
 */
public class ThreadMain {


    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}




