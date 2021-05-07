package com.jetco.core.creative.simplefactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 奔驰汽车
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class Benz implements Car {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("奔驰汽车启动了！");
    }

    @Override
    public void stop() {
        logger.info("奔驰汽车停止了！");
    }

    @Override
    public void description() {
        logger.info("这是奔驰汽车！");
    }
}
