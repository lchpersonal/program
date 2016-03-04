package com.cl.test.object;

/**
 * Created by chengli on 2016/3/4.
 */
public class WaitMethod {


    public static void main(String[] args) throws InterruptedException {
        Thread t  = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        });
        t.start();
        //t.join();
        synchronized (t){
            //理解为t这个线程需要比别人的等待。实际等待的是主线程
            t.wait(0);
        }
        System.out.println("haha");
    }
}
