package com.cl.test.thread;

/**
 * @Author: chengli
 * @Date: 2018/8/8 10:12
 */
public class Producer implements Runnable {
    private Repository repository = Repository.getInstance();
    private Object lock = repository.getLock();

    @Override
    public void run() {
        while (true) {
            int productNum = repository.getProductNum();
            if (productNum >= 1) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                }
            } else {
                repository.put();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
