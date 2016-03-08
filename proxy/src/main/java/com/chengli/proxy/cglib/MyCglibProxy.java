package com.chengli.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.*;
import org.apache.log4j.Logger;

public class MyCglibProxy implements MethodInterceptor {
    private Logger log = Logger.getLogger(MyCglibProxy.class);
    private String name;

    public MyCglibProxy(String name) {
        this.name = name;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        log.info("调用的方法是：" + method.getName());
        //用户进行判断
        if (!"张三".equals(name)) {
            System.out.println("你没有权限！");
            return null;
        }
        return methodProxy.invokeSuper(object, args);
    }
} 