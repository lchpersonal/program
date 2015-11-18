package com.chengli.dev.filter;


/**
 * Created by chengli on 2015/11/17.
 */
public interface Filter {

    String doFilter(String in, String out, FilterChain filterChain) throws Exception;
}
