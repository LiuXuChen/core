package com.jetco.core.structural.combination;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 叶子节点  模拟某个部门
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-03-14
 */
@Slf4j
public class Department implements Company {

    private final String name;

    public Department(String name) {
        this.name = name;
    }

    @Override
    public void add(Company company) {
        log.info("不是子容器");
    }

    @Override
    public void remove(Company company) {
        log.info("不是子容器");
    }

    @Override
    public void display(int depth) {
        StringBuilder sb = new StringBuilder("-");
        for (int i = 0; i < depth ; i++) {
            sb.append("-");
        }
        log.info(sb.append(name).toString());
    }

    @Override
    public void business() {
        String business = "";
        if(name.contains("销售")) {
            business = "产品销售！";
        } else if(name.contains("研发")) {
            business = "产品研发！";
        } else if(name.contains("产品")) {
            business = "产品设计！";
        } else if(name.contains("国土")) {
            business = "国土项目！";
        } else if(name.contains("官网")) {
            business = "管网项目！";
        } else if(name.contains("政企")) {
            business = "政企项目！";
        } else {
            business = "打杂！";
        }
        log.info("[{}]===负责业务方向是===[{}]", name, business);
    }
}
