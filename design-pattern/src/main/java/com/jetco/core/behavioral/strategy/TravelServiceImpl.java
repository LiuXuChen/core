package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 出行服务接口实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@Service
public class TravelServiceImpl implements TravelService {

    @Resource
    private TravelStrategyHandlerFactory travelStrategyHandlerFactory;

    @Override
    public Result<String> getTravelType(@NonNull RequestParam requestParam) {
        String requestType = requestParam.getRequestType();
        // 根据requestType找到对应的提交处理器
        TravelStrategyHandler<Serializable> travelStrategyHandler = travelStrategyHandlerFactory.getTravelStrategyHandler(requestType);
        // 判断requestType对应的handler是否存在
        if (travelStrategyHandler == null) {
            return Result.failure("非法的请求类型: " + requestType);
        }
        // 处理提交
        return travelStrategyHandler.handleRequest(requestParam);
    }
}
