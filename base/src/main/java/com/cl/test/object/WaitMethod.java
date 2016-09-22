package com.cl.test.object;

/**
 * Created by chengli on 2016/3/4.
 */
public class WaitMethod {

    static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {

        /*new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized (o) {
                    o.notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        }).start();*/
        new Thread(() -> {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }).start();

        test();
        System.out.println("haha");
    }

    public static void test() throws InterruptedException {
        System.out.println("test run~: " + Thread.currentThread().getName());
        synchronized (o) {
            //理解为t这个线程需要被别人的等待。实际等待的是主线程
            System.out.println("befroe wait~~" + Thread.currentThread().getName());
            o.wait();
            Thread.sleep(5000);
            System.out.println("after wait~~" + Thread.currentThread().getName());
            //Thread.currentThread().wait();
        }

    }
}
