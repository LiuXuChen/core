package com.jetco.core.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 游戏软件实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-08
 */
public class GameSoft extends AbstractSoft {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void rerun() {
        logger.info("游戏软件运行中。。。。。。");
    }
}
