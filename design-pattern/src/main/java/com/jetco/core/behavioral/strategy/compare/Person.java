package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 人：比较高低
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
public class Person {

    private String name;

    private int height;

    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}
