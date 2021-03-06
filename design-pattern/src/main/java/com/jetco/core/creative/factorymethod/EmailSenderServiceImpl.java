package com.jetco.core.creative.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 邮件发送服务接口实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class EmailSenderServiceImpl implements SenderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void send() {
        logger.info("发送邮件！");
    }
}
