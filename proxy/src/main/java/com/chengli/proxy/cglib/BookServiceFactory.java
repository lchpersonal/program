package com.chengli.proxy.cglib;

public class BookServiceFactory {
    private static BookServiceBean dao = new BookServiceBean();

    private BookServiceFactory() {
    }

    public static BookServiceBean getInstance() {
        return dao;
    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy){
        //生成代理实例
        return (BookServiceBean) myProxy.getDaoBean(BookServiceBean.class);
    }
}