package com.jetco.core.creative.factorymethod;

/**
 * <p>
 * 邮件发送工厂接口实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class EmailSendFactory implements Factory {

    @Override
    public SenderService getSenderService() {
        return new EmailSenderServiceImpl();
    }
}
