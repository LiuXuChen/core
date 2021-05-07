package com.jetco.core.behavioral.iterator;

/**
 * <p>
 * 迭代器
 *
 * 迭代器模式（游标模式）：提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public interface Iterator<E> {

    /**
     * 是否存在下一个元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 获取下个元素
     * @return
     */
    E next();

}
