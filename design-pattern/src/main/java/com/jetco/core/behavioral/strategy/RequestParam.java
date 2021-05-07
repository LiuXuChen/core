package com.jetco.core.behavioral.strategy;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>
 * 请求参数
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@Data
public class RequestParam implements Serializable {

    /**
     * 请求类型（策略类型）
     */
    private String requestType;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 其他请求参数
     */
    private transient Map<String, Object> params;
}
