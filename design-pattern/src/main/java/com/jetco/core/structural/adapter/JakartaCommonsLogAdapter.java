package com.jetco.core.structural.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * apache commons logging 日志适配器实现
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public class JakartaCommonsLogAdapter implements LogAdapter {

    private final Log logger;

    public JakartaCommonsLogAdapter(String clazz) {
        this.logger = LogFactory.getLog(clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void error(String msg, Throwable throwable) {
        this.logger.error(msg, throwable);
    }

    @Override
    public void error(String msg) {
        this.logger.error(msg);
    }

    @Override
    public void debug(String msg) {
        this.logger.debug(msg);
    }

    @Override
    public void trace(String msg) {
        this.logger.trace(msg);
    }

    @Override
    public void warn(String msg) {
        this.logger.warn(msg);
    }
}
