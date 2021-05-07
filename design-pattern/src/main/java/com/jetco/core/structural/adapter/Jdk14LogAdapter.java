package com.jetco.core.structural.adapter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * jdk14日志适配器实现
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public class Jdk14LogAdapter implements LogAdapter {

    private final Logger logger;

    public Jdk14LogAdapter(String clazz) {
        this.logger = Logger.getLogger(clazz);
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isLoggable(Level.FINE);
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isLoggable(Level.FINER);
    }

    @Override
    public void error(String msg, Throwable throwable) {
        this.logger.log(Level.SEVERE, msg, throwable);
    }

    @Override
    public void error(String msg) {
        this.logger.log(Level.SEVERE, msg);
    }

    @Override
    public void debug(String msg) {
        this.logger.log(Level.FINE, msg);
    }

    @Override
    public void trace(String msg) {
        this.logger.log(Level.FINER, msg);
    }

    @Override
    public void warn(String msg) {
        this.logger.log(Level.WARNING, msg);
    }
}
