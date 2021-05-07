package com.jetco.core.behavioral.responsibilitychain;

/**
 * <p>
 * 审批服务接口
 *
 * 责任链模式：
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。
 * 将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-23
 */
public interface ApproveService {

    /**
     * 获取审批事件级别
     * @return
     */
    int getEventLevel();

    /**
     * 获取审批事件内容
     * @return
     */
    String getEventContent();

}
