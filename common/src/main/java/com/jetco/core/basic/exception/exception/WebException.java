package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2020-01-17
 * @version 1.0
 */
public class WebException extends AbstractException {

    public WebException(String message) {
        super(message, 400);
    }

    public WebException() {
        super("请求失败", 400);
    }
}