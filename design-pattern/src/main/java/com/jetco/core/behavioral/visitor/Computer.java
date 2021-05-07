package com.jetco.core.behavioral.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 存储设备-电脑
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public class Computer {

    /**
     * 电脑中的文件夹和文件列表
     */
    private final List<Element> elements = new LinkedList<>();

    {
        elements.add(new DirectoryElement("learn", "movie"));
        elements.add(new FileElement("设计模式之蝉","第一滴血.avi"));
    }

    /**
     * 展示电脑中的文件夹和文件
     * @param visitor
     */
    public void display(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

}
