package com.jetco.core.structural.appearance;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * Memory子系统类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-14
 */
@Slf4j
public class Memory {

    /**
     * 该方法为子系统内部模块之间相互调用时使用的方法
     */
    public void run() {
        log.info("memory运行中。。。。。。");
    }

    /**
     * 以下方法为提供给子系统外部使用的方法
     */
    public void start() {
        log.info("memory启动中。。。。。。");
    }

    public void shutdown() {
        log.info("memory关闭中。。。。。。");
    }
}
