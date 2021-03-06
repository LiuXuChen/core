package com.jetco.core.behavioral.responsibilitychain;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 省级事件处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-23
 */
@Slf4j
public class ProvincialEventHandler extends EventHandler {

    ProvincialEventHandler() {
        super(EventLevel.PROVINCIAL_LEVEL_OF_APPROVAL.getLevel());
    }

    @Override
    protected void handleResult(ApproveService approveService) {
        log.info("事件级别为：{}、事件内容为：{}的审批已处理", approveService.getEventLevel(), approveService.getEventContent());
    }
}
