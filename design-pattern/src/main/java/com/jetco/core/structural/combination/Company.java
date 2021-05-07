package com.jetco.core.structural.combination;

/**
 * <p>
 * 抽象构件：公司接口
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-14
 */
public interface Company {

    /**
     * 增加子公司或子部门
     * @param company
     */
    void add(Company company);

    /**
     * 移除子公司或子部门
     * @param company
     */
    void remove(Company company);

    /**
     * 查询该节点下所有子公司或子部门
     * @param depth
     */
    void display(int depth);

    /**
     * 不同子公司或子部门所负责的业务
     */
    void business();
}
