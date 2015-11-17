package com.chengli.dev.interceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengli on 2015/11/17.
 */
public class InterceptorChain {

    private List<Interceptor> interceptors = new ArrayList<Interceptor>();

    public Object pluginAll(Object target) {
        for (Interceptor interceptor : interceptors) {
            target = interceptor.warp(target);
        }
        return target;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }
}
