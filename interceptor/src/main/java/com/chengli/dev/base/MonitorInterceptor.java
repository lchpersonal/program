package com.chengli.dev.base;

import com.chengli.dev.interceptor.IExecutor;
import com.chengli.dev.interceptor.Interceptor;
import com.chengli.dev.interceptor.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chengli on 2015/11/17.
 */
public class MonitorInterceptor implements Interceptor {

    public Object plugin(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        long beginTime = System.currentTimeMillis();
        Object result = invocation.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("run cost: %s ms", (endTime - beginTime)));
        return result;
    }

    public Object warp(Object target) {
        return Proxy.newProxyInstance(Interceptor.class.getClassLoader(), new Class[]{IExecutor.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
    }
}
