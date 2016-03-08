package com.chengli.proxy.cglib;

/**
 * 参见文档，印象笔记 cglib动态代理介绍
 * 源地址：http://blog.csdn.net/xiaohai0504/article/details/6832990
 */
public class Client {

    public static void main(String[] args) {
        BookServiceBean service = BookServiceFactory.getProxyInstance(new MyCglibProxy("张三1"));
        doMethod(service);
    }

    public static void doMethod(BookServiceBean service) {
        service.create();
        service.update();
        service.query();
        service.delete();
    }
}   