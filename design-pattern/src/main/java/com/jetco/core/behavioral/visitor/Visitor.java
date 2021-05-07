package com.jetco.core.behavioral.visitor;

/**
 * <p>
 * 抽象的访问者
 *
 * 访问者模式：将数据结构和数据操作相分离
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public interface Visitor {

    /**
     * 定义对不同的元素（文件夹）进行访问的具体行为
     * @param directoryElement
     */
    void visit(DirectoryElement directoryElement);

    /**
     * 定义对不同的元素（文件）进行访问的具体行为
     * @param fileElement
     */
    void visit(FileElement fileElement);

}
