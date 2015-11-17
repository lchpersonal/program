package com.chengli.dev.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chengli on 2015/11/17.
 */
public class Invocation {

    private Object clazz;
    private Method method;
    private Object[] args;

    public Invocation(Object clazz, Method method, Object[] args) {
        this.clazz = clazz;
        this.method = method;
        this.args = args;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
       return method.invoke(clazz, args);
    }

}
