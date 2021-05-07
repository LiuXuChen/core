package com.jetco.core.basic.exception;

import com.jetco.sand.core.bean.Result;
import com.jetco.sand.core.bean.ResultCodeEnum;
import com.jetco.sand.exception.exception.AbstractException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * <p>
 *  全局异常处理
 * </p>
 *
 * @author lhw
 * @since 2020-06-06
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public <T extends Throwable> Result handleException(T e) {
        if (e instanceof AbstractException) {
            AbstractException baseException = (AbstractException)e;
            return Result.failure(baseException);
        }else if(e instanceof MethodArgumentNotValidException) {
            // MethodArgumentNotValidException为注解校验异常类
            // 获取注解校验异常信息
            StringBuilder sb = new StringBuilder("错误信息如下：").append("\r\n");
            List<FieldError> errorList = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();
            for (FieldError error : errorList) {
                //验证错误信息
                String errorMsg = error.getDefaultMessage();
                sb.append("      ").append(errorMsg).append("\r\n");
            }
            String error = sb.substring(0, sb.length() - 1);
            return error != null ? Result.failure(ResultCodeEnum.PARAM_VALID_IS_BLANK.getCode(), error) : Result.failure(ResultCodeEnum.UNDEFINE.getCode(), ResultCodeEnum.UNDEFINE.getMessage());
        } else {
            return Result.failure(1000, e.getMessage());
        }
    }

}
