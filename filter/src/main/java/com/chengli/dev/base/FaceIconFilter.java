package com.chengli.dev.base;

import com.chengli.dev.filter.Filter;
import com.chengli.dev.filter.FilterChain;

/**
 * Created by chengli on 2015/11/18.
 */
public class FaceIconFilter implements Filter {
    public String doFilter(String in, String out, FilterChain filterChain) throws Exception {
        in = in.replaceAll("笑脸", "<^_^>");
        System.out.println(in);
        filterChain.doFilter(in, out, filterChain);
        out = in;
        return out;
    }
}
