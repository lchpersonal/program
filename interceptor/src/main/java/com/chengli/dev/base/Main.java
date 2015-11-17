package com.chengli.dev.base;

import com.chengli.dev.interceptor.BaseExecutor;
import com.chengli.dev.interceptor.IExecutor;

/**
 * Created by chengli on 2015/11/17.
 */
public class Main {

    public static void main(String[] args) {
        IExecutor executor = new BaseExecutor();
        executor.run();
    }
}
