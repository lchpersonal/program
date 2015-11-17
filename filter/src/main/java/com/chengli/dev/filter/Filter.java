package com.chengli.dev.filter;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

/**
 * Created by chengli on 2015/11/17.
 */
public interface Filter {

    void doFilter(HttpRequest request, HttpResponse response, FilterChain filterChain) throws Exception;
}
