package com.jetco.core.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 静态代理购票
 *
 *  静态代理模式：
 *  两个子类共同实现一个接口，其中一个子类负责真实业务实现，另一个子类充当中介者辅助完成真实业务主题的操作。
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-18
 */
@Slf4j
public class StaticProxy implements IBuyTicketService {

    private final IBuyTicketService buyTicketService;

    /**
     * 构造注入，注入真实主题类，构造函数传入的是接口类型的参数，
     * 是因为不知道具体的真实主题类是哪一个，所以传一个接口类型的
     */
    public StaticProxy(IBuyTicketService buyTicketService) {
        this.buyTicketService = buyTicketService;
    }

    @Override
    public void buyTicket() {
        // 购票前的操作
        this.beforeBuyTicket();
        // 真正的购票操作，但这个操作是客户来完成的，所以需要通过构造方法把真实客户传进来，通过真实主题类来完成这个操作
        buyTicketService.buyTicket();
        // 购票后的操作
        this.afterBuyTicket();
    }

    private void beforeBuyTicket(){
        log.info("去火车站售票窗口排队、付钱。。。。。。");
    }

    private void afterBuyTicket(){
        log.info("从火车站进站口排队、人脸识别、安检。。。。。。");
    }
}
