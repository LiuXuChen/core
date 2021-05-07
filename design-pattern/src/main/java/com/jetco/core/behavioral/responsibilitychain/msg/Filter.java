package com.jetco.core.behavioral.responsibilitychain.msg;

/**
 * <p>
 * 过滤器接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public interface Filter {

    /**
     * 处理消息
     * @param msg
     * @return 返回true继续执行过滤器链，返回false过滤器链返回结果
     */
    boolean doFilter(Msg msg);
}
