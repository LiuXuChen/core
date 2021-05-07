package com.jetco.core.creative.singleton;

import com.jetco.sand.exception.exception.ParameterException;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * <p>
 * 获取单例对象的工厂类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-01
 */
@Component
public final class SingletonFactory {

    private static final Map<String, Object> OBJECT_MAP = Maps.newHashMap();

    private SingletonFactory() {
    }

    public static <T> T getInstance(Class<T> clazz) {
        String key = clazz.toString();
        Object instance;
        synchronized (SingletonFactory.class) {
            instance = OBJECT_MAP.get(key);
            if (instance == null) {
                try {
                    instance = clazz.getDeclaredConstructor().newInstance();
                    OBJECT_MAP.put(key, instance);
                } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    throw new ParameterException(e.getMessage());
                }
            }
        }
        return clazz.cast(instance);
    }
}
