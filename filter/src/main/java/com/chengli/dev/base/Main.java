package com.chengli.dev.base;

import com.chengli.dev.filter.FilterChain;

/**
 * Created by chengli on 2015/11/17.
 */
public class Main {

    private static String str = "你好啊,敏感信息，笑脸";

    public static void main(String[] args) throws Exception {
        FilterChain chain = new FilterChain();
        chain.addFilter(new SensitiveFilter());
        chain.addFilter(new FaceIconFilter());
        chain.doFilter(str, null, chain);
    }
}
