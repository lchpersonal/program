package com.chengli.dev.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengli on 2015/11/17.
 */
public class FilterChain {

    private List<Filter> filters = new ArrayList<Filter>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public List<Filter> getFilters() {
        return filters;
    }
}
