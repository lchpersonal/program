package com.chengli.dev.base;

import com.chengli.dev.interceptor.BaseExecutor;
import com.chengli.dev.interceptor.IExecutor;
import com.chengli.dev.interceptor.InterceptorChain;

/**
 * Created by chengli on 2015/11/17.
 */
public class Main {

    public static void main(String[] args) {
        IExecutor executor = new BaseExecutor();
        executor = (IExecutor) getInterceptorChain().pluginAll(executor);
        executor.run();
    }

    private static InterceptorChain getInterceptorChain(){
        InterceptorChain interceptorChain = new InterceptorChain();
        interceptorChain.addInterceptor(new MonitorInterceptor());
        return interceptorChain;
    }
}
