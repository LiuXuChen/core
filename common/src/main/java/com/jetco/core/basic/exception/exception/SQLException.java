package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2019-12-24
 * @version 1.0
 */
public class SQLException extends AbstractException {

    public SQLException(String message) {
        super(message, 4000);
    }

    public SQLException() {
        super("执行SQL出现错误，请查看日志", 4000);
    }

}
