package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;

/**
 * <p>
 * 出行服务接口类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
public interface TravelService {

    /**
     * 获取出行类型
     * @param requestParam 请求参数
     * @return 响应结果
     */
    Result<String> getTravelType(RequestParam requestParam);
}
