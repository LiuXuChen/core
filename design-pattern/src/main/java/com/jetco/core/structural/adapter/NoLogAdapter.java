package com.jetco.core.structural.adapter;

/**
 * <p>
 * 没有Log适配器
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public class NoLogAdapter implements LogAdapter {

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public void error(String msg, Throwable throwable) {

    }

    @Override
    public void error(String msg) {

    }

    @Override
    public void debug(String msg) {

    }

    @Override
    public void trace(String msg) {

    }

    @Override
    public void warn(String msg) {

    }
}
