package com.jetco.core.behavioral.visitor;

/**
 * <p>
 * 抽象的访问元素
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public interface Element {

    /**
     * 接受访问者进行访问
     * @param visitor
     */
    void accept(Visitor visitor);
}
