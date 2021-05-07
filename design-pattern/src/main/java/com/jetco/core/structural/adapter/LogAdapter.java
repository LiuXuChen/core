package com.jetco.core.structural.adapter;

/**
 * <p>
 * 日志适配器接口
 * 适配器模式：将一个接口转换成客户希望的另一个接口，适配器模式使接口不兼容的那些类可以一起工作。
 * 适配器模式既可以作为类结构型模式，也可以作为对象结构型模式
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-03
 */
public interface LogAdapter {

    /**
     * 是否允许调试
     * @return true or false
     */
    boolean isDebugEnabled();

    /**
     * 是否允许跟踪
     * @return true or false
     */
    boolean isTraceEnabled();

    /**
     * 错误日志
     * @param msg 错误消息
     * @param throwable 异常
     */
    void error(String msg, Throwable throwable);

    /**
     * 错误日志
     * @param msg 错误消息
     */
    void error(String msg);

    /**
     * 调试日志
     * @param msg 调试消息
     */
    void debug(String msg);

    /**
     * 跟踪日志
     * @param msg 跟踪消息
     */
    void trace(String msg);

    /**
     * 警告日志
     * @param msg 警告消息
     */
    void warn(String msg);
}
