package com.jetco.core.structural.combination;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 具体的公司类 树枝节点
 * 复合组件构件类 模拟某个公司
 * 组合模式：
 * 将对象组合成树形结构以表示“部分-整体”的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-14
 */
@Slf4j
public class ConcreteCompany implements Company {

    private final String name;

    private final List<Company> companyList = new ArrayList<>();

    public ConcreteCompany(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {
        companyList.add(company);
    }

    @Override
    public void remove(Company company) {
        companyList.remove(company);
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder("-");
        for (int i = 0; i < depth ; i++) {
            sb.append("-");
        }
        log.info(sb.append(name).toString());
        for (Company company: companyList) {
            company.display(depth+2);
        }
    }

    @Override
    public void business() {
        for (Company company : companyList) {
            company.business();
        }
    }
}
