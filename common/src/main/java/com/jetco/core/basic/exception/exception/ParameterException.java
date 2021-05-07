package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2019-12-24
 * @version 1.0
 */
public class ParameterException extends AbstractException {

    public ParameterException(String message) {
        super(message, 3000);
    }

    public ParameterException() {
        super("参数错误", 3000);
    }

}
