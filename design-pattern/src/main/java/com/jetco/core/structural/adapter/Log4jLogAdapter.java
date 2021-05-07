package com.jetco.core.structural.adapter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * <p>
 * log4j日志适配器实现
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public class Log4jLogAdapter implements LogAdapter {

    private static final String FQCN = Log4jLogAdapter.class.getName();

    private final Logger logger;

    public Log4jLogAdapter(String clazz) {
        this.logger = Logger.getLogger(clazz);
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
        this.logger.log(FQCN, Level.ERROR, msg, throwable);
    }

    @Override
    public void error(String msg) {
        this.logger.log(FQCN, Level.ERROR, msg, (Throwable)null);
    }

    @Override
    public void debug(String msg) {
        this.logger.log(FQCN, Level.DEBUG, msg, (Throwable)null);
    }

    @Override
    public void trace(String msg) {
        this.logger.log(FQCN, Level.TRACE, msg, (Throwable)null);
    }

    @Override
    public void warn(String msg) {
        this.logger.log(FQCN, Level.WARN, msg, (Throwable)null);
    }
}
