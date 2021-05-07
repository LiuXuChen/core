package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 猪：比较重量
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
public class Pig {

    private String name;

    private int weight;

    public Pig(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
