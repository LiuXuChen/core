package com.jetco.core.behavioral.responsibilitychain;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 审批事件处理
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-23
 */
@Slf4j
public abstract class EventHandler {

    /**
     * 处理的审批事件级别
     */
    private int level = EventLevel.COUNTY_LEVEL_OF_APPROVAL.getLevel();

    /**
     * 下一个审批事件处理者
     */
    private EventHandler nextEventHandler;

    EventHandler(int level) {
        this.level = level;
    }

    /**
     * 负责ApproveService的审批服务，final关键字声明不允许被覆盖
     * @param approveService
     */
    final void handleEvent(ApproveService approveService) {
        // 如果审批事件级别小于等于可以处理的级别就直接审批
        if(approveService.getEventLevel() <= this.level) {
            this.handleResult(approveService);
        } else {
            // 有后续环节，审批传递
            if (this.nextEventHandler != null) {
                this.nextEventHandler.handleEvent(approveService);
            } else {
                // 无后续环节，提示
                log.info("事件级别为：{}的审批无法处理", approveService.getEventLevel());
            }
        }
    }

    /**
     * 处理结果
     * @param approveService
     */
    protected abstract void handleResult(ApproveService approveService);

    /**
     * 如果你没有审批的权限，那么应该转至下一环节的处理者
     * @param nextEventHandler
     */
    public void setNextEventHandler(EventHandler nextEventHandler) {
        this.nextEventHandler = nextEventHandler;
    }
}
