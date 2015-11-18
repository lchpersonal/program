package com.chengli.dev.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengli on 2015/11/17.
 */
public class FilterChain implements Filter {

    private static int index = 0;

    private List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public String doFilter(String in, String out, FilterChain filterChain) throws Exception {
        if (index <= filters.size() - 1) {
            Filter filter = this.getFilters().get(index);
            index++;
            return filter.doFilter(in, out, filterChain);
        }
        return in;
    }
}
