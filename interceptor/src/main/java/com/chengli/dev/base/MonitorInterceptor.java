package com.chengli.dev.base;

import com.chengli.dev.interceptor.Interceptor;
import com.chengli.dev.interceptor.Invocation;
import com.chengli.dev.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;

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
        return Plugin.wrap(target, this);
    }
}
