package com.jetco.core.creative.abstractfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 华为电脑
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class HuaWeiComputer implements Computer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void description() {
        logger.info("我是华为电脑！");
    }
}
