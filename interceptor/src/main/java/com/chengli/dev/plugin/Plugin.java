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

    /**
     * @param proxy  生成的代理类对象
     * @param method 调用的方法
     * @param args   方法参数
     */

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.plugin(new Invocation(target, method, args));
    }
}
