package com.jetco.core.behavioral.strategy;

import com.jetco.sand.core.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * <p>
 * 火车出行策略处理实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@Component
public class TrainTravelStrategyHandler implements TravelStrategyHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getRequestType() {
        return "train";
    }

    @Override
    public Result<String> handleRequest(RequestParam requestParam) {
        logger.info("火车模式出行：userId={}, params={}", requestParam.getUserId(), requestParam.getParams());
        return Result.success("train", "火车模式出行！");
    }
}
