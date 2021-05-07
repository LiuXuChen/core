package com.jetco.core.structural.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 具体的组件对象
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-04
 */
public class WearComponent implements IComponent {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String description(String msg) {
        logger.info(msg);
        return msg;
    }
}
