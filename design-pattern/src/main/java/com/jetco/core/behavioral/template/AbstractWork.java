package com.jetco.core.behavioral.template;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 上班抽象模板类
 *
 * 模板模式：
 * 模板类定义一个操作中的算法骨架，而将一些步骤延迟到子类中，
 * 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-22
 */
@Slf4j
public abstract class AbstractWork {

    /**
     * 模板方法，去上班
     */
    public void goWork() {
        this.beforeWork();
        this.commute();
        this.arrive();
        this.working();
        this.afterWork();
    }

    /**
     * 具体方法，子类不可修改：上班前
     */
    private void beforeWork() {
        log.info("1、起床、锻炼、洗漱、吃早餐！");
    }

    /**
     * 抽象方法，必须有子类实现：通勤
     */
    public abstract void commute();

    /**
     * 具体方法，子类不可修改：到达公司
     */
    private void arrive() {
        log.info("3、到达公司！");
    }

    /**
     * 抽象方法，必须有子类实现：工作中
     */
    public abstract void working();

    /**
     * 钩子方法，子类可以选择重写或不重写：下班后
     */
    protected void afterWork() {
        log.info("5、下班回家、买菜、做饭、吃饭、洗碗、洗澡、看电视、睡觉！");
    }

}
