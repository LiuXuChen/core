package com.jetco.core.structural.adapter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

/**
 * <p>
 * log4j2日志适配器实现
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public class Log4j2LogAdapter implements LogAdapter {

    private static final Marker MARKER = MarkerManager.getMarker("MYBATIS");

    private final Logger logger;

    public Log4j2LogAdapter(Logger logger) {
        this.logger = logger;
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
        this.logger.error(MARKER, msg, throwable);
    }

    @Override
    public void error(String msg) {
        this.logger.error(MARKER, msg);
    }

    @Override
    public void debug(String msg) {
        this.logger.debug(MARKER, msg);
    }

    @Override
    public void trace(String msg) {
        this.logger.trace(MARKER, msg);
    }

    @Override
    public void warn(String msg) {
        this.logger.warn(MARKER, msg);
    }
}
