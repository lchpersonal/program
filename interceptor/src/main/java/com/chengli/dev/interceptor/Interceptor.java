package com.chengli.dev.interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chengli on 2015/11/17.
 */
public interface Interceptor {

    Object plugin(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    Object warp(Object target);
}
