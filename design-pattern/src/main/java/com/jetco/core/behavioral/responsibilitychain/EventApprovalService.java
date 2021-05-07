package com.jetco.core.behavioral.responsibilitychain;

/**
 * <p>
 * 事件审批
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-23
 */
public class EventApprovalService implements ApproveService {

    private final int level;

    private final String eventContent;

    EventApprovalService(int level, String eventContent) {
        this.level = level;
        this.eventContent = "事件级别为" + level + "的事件内容是：" + eventContent;
    }

    @Override
    public int getEventLevel() {
        return this.level;
    }

    @Override
    public String getEventContent() {
        return this.eventContent;
    }
}
