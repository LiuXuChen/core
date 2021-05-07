package com.jetco.core.structural.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 苹果手机实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-08
 */
public class AppleMobilePhone extends AbstractMobilePhone {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public AppleMobilePhone(AbstractSoft abstractSoft) {
        super(abstractSoft);
    }

    @Override
    public void run() {
        // 使用委托：调用AppleMobilePhone的run时，实际调用的是SoftImplementor的rerun
        this.abstractSoft.rerun();
    }

    public void appleSystemRun() {
        logger.info("苹果系统运行开始。。。。。。");
        this.run();
        logger.info("苹果系统运行结束。。。。。。");
    }
}
