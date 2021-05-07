package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <p>
 * 高铁出行策略处理实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@Component
public class HighTrainTravelStrategyHandler implements TravelStrategyHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getRequestType() {
        return "high-train";
    }

    @Override
    public Result<String> handleRequest(RequestParam requestParam) {
        logger.info("高铁模式出行：userId={}, params={}", requestParam.getUserId(), requestParam.getParams());
        return Result.success("high-train", "高铁模式出行！");
    }
}
