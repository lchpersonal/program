package com.chengli.dev.base;

import com.chengli.dev.filter.Filter;
import com.chengli.dev.filter.FilterChain;

/**
 * 过滤敏感字
 * Created by chengli on 2015/11/17.
 */
public class SensitiveFilter implements Filter {

    public String doFilter(String in, String out, FilterChain filterChain) throws Exception {
        in = in.replaceAll("敏感信息","****");
        filterChain.doFilter(in,out,filterChain);
        out = in;
        return out;
    }
}
