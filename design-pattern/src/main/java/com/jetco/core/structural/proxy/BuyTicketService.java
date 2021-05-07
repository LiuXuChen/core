package com.jetco.core.structural.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 购票服务接口的具体实现类
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-13
 */
@Slf4j
public class BuyTicketService implements IBuyTicketService {

    @Override
    public void buyTicket() {
        log.info("购票进行中。。。。。。");
    }
}
