package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 狗：比较年龄
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
public class Dog {

    public String name;

    public int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
