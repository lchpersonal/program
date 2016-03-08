package com.chengli.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chengli on 2016/3/8.
 */
public class LogInvocationHandler implements InvocationHandler {

    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin~~~");
        Object result = method.invoke(this.target, args);
        System.out.println("end ~~~");
        return result;

    }
}
