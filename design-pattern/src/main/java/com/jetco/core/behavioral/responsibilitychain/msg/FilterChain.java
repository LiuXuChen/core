package com.jetco.core.behavioral.responsibilitychain.msg;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 过滤器链
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class FilterChain implements Filter {

    private final List<Filter> filters = new ArrayList<>();

    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            if(!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}
