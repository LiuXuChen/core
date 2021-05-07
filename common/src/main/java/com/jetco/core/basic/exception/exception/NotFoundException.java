package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2019-12-21
 * @version 1.0
 */
public class NotFoundException extends AbstractException {

    public NotFoundException(String message) {
        super(message, 999);
    }

    public NotFoundException() {
        super("未找到相应的资源", 999);
    }
}
