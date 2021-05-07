package com.jetco.core.behavioral.responsibilitychain;

/**
 * <p>
 * 事件级别
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-23
 */
public enum EventLevel {

    /**
     * 审批事件级别的枚举
     */
    COUNTY_LEVEL_OF_APPROVAL(1),
    MUNICIPAL_LEVEL_OF_APPROVAL(2),
    PROVINCIAL_LEVEL_OF_APPROVAL(3),
    NATIONAL_LEVEL_OF_APPROVAL(4);

    private final int level;

    EventLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
