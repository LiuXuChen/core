package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;

import java.io.Serializable;

/**
 * <p>
 * 定义旅游出行策略接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
public interface TravelStrategyHandler<T extends Serializable> {


    /**
     * 获得请求类型（返回值也可以使用已经存在的枚举类）
     * @return 请求类型
     */
    String getRequestType();

    /**
     * 处理提交请求
     * @param requestParam 请求参数
     * @return 响应结果
     */
    Result<String> handleRequest(RequestParam requestParam);

}
