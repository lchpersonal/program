package com.chengli.dev.interceptor;

import com.chengli.dev.plugin.Plugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * Created by chengli on 2015/11/17.
 */
public interface Interceptor {

    Object plugin(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    default Object wrap(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new Plugin(target, this));
    }
}
