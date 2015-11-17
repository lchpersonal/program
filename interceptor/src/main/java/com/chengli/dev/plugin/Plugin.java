package com.chengli.dev.plugin;

import com.chengli.dev.interceptor.Interceptor;
import com.chengli.dev.interceptor.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chengli on 2015/11/17.
 */
public class Plugin implements InvocationHandler {

    private Object target;
    private Interceptor interceptor;

    public Plugin(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.plugin(new Invocation(target, method, args));
    }

    public static Object wrap(Object target, Interceptor interceptor) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                new Class[]{target.getClass().getInterfaces()[0]}, new Plugin(target, interceptor));
    }
}
