package com.jetco.core.behavioral.iterator;

/**
 * <p>
 * 集合
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public interface Collection<E> {

    /**
     * 添加元素
     * @param e
     */
    void add(E e);

    /**
     * 元素数量
     * @return
     */
    int size();

    /**
     * 元素迭代
     * @return
     */
    Iterator<E> iterator();
}
