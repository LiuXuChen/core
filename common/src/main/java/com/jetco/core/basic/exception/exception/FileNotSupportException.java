package com.jetco.core.basic.exception.exception;

/**
 * @author liuhongwei
 * @since 2019-12-24
 * @version 1.0
 */
public class FileNotSupportException extends AbstractException {

    public FileNotSupportException(String message) {
        super(message, 2000);
    }

    public FileNotSupportException() {
        super("该类型的文件不支持上传 ", 2000);
    }

}
