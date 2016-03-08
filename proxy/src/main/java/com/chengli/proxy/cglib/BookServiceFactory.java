package com.chengli.proxy.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class BookServiceFactory {
    private static BookServiceBean dao = new BookServiceBean();

    private BookServiceFactory() {
    }

    public static BookServiceBean getInstance() {
        return dao;
    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
        //生成代理实例
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BookServiceBean.class);
        enhancer.setCallbacks(new Callback[]{myProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new MyProxyFilter());
        return (BookServiceBean) enhancer.create();
    }
}