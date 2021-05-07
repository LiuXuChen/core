package com.jetco.core.behavioral.strategy;

import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 旅游出行策略处理工厂类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-02-27
 */
@Component
public class TravelStrategyHandlerFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<String, TravelStrategyHandler<Serializable>> TRAVEL_STRATEGY_HANDLER_MAP = new HashMap<>(8);

    private ApplicationContext applicationContext;

    /**
     * 根据请求类型获取对应的策略处理器
     * @param requestType 请求类型
     * @return 请求类型对应的策略处理器
     */
    public TravelStrategyHandler<Serializable> getTravelStrategyHandler(String requestType) {
        return TRAVEL_STRATEGY_HANDLER_MAP.get(requestType);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 将Spring容器中所有的TravelStrategyHandler注册到TRAVEL_STRATEGY_HANDLER_MAP
        applicationContext.getBeansOfType(TravelStrategyHandler.class).values().forEach(handler -> TRAVEL_STRATEGY_HANDLER_MAP.put(handler.getRequestType(), handler));
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
