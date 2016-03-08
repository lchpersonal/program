package com.chengli.proxy.cglib;

/**
 * Created by chengli on 2016/3/8.
 */
public class BookServiceBean {
    public void create() {
        System.out.println("create() is running !");
    }

    public void query() {
        System.out.println("query() is running !");
    }

    public void update() {
        System.out.println("update() is running !");
    }

    public void delete() {
        System.out.println("delete() is running !");
    }
}
