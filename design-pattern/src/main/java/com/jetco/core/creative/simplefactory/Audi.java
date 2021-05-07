package com.jetco.core.creative.simplefactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 奥迪汽车
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class Audi implements Car {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run() {
        logger.info("奥迪汽车启动了！");
    }

    @Override
    public void stop() {
        logger.info("奥迪汽车启动了！");
    }

    @Override
    public void description() {
        logger.info("这是奥迪汽车！");
    }
}
