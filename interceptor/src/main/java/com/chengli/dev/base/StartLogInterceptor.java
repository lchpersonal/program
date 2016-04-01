package com.chengli.dev.base;

import com.chengli.dev.interceptor.Interceptor;
import com.chengli.dev.interceptor.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chengli on 2015/11/17.
 */
public class StartLogInterceptor implements Interceptor {

    public Object plugin(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("start ```");
        Object result = invocation.proceed();
        System.out.println("end ````");
        return result;
    }

}
