package com.cl.test.thread;

/**
 * @Author: chengli
 * @Date: 2018/8/8 10:12
 */
public class Consumer implements Runnable {

    private Repository repository = Repository.getInstance();
    private Object lock = repository.getLock();


    @Override
    public void run() {
        while (true) {
            int productNum = repository.getProductNum();
            if (productNum <= 0) {
                synchronized (lock) {
                    try {
                        lock.wait();
                        lock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                repository.get();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
