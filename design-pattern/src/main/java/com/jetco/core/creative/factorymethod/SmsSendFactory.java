package com.jetco.core.creative.factorymethod;

/**
 * <p>
 * 短信发送工厂接口实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-02
 */
public class SmsSendFactory implements Factory {

    @Override
    public SenderService getSenderService() {
        return new SmsSenderServiceImpl();
    }
}
