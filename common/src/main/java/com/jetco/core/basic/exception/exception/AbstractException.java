package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2019-12-21
 * @version 1.0
 */
public abstract class AbstractException extends RuntimeException {

    protected final int code;

    public AbstractException(String message, int code) {
        super(message != null && message.trim().length() != 0 ? message : "错误");
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
