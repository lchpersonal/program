package com.cl.test.thread;

/**
 * @Author: chengli
 * @Date: 2018/8/8 10:33
 * 商品仓库
 */
public class Repository {

    /**
     * 操作商品资格证（锁）
     */
    private final Object lock = new Object();

    private int productNum = 0;

    private static Repository INSTANCE;

    private Repository() {

    }

    public Object getLock() {
        return lock;
    }

    private static final Object synLock = new Object();

    public static Repository getInstance() {
        if (INSTANCE == null) {
            synchronized (synLock) {
                if (INSTANCE == null) {
                    INSTANCE = new Repository();
                }
            }
        }
        return INSTANCE;
    }

    public void get() {
        if (productNum > 0) {
            productNum -= 1;
            System.out.println("取出商品一件，剩余：" + productNum);
        }
    }

    public void put() {
        if (productNum == 0) {
            productNum += 1;
            System.out.println("生产商品一件，当前数量：" + productNum);
        }
    }

    public int getProductNum() {
        return productNum;
    }
}
