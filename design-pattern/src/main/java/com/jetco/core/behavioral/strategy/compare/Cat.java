package com.jetco.core.behavioral.strategy.compare;

/**
 * <p>
 * 猫：比较命的多少
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-18
 */
public class Cat {

    private String name;

    private int life;

    public Cat(String name, int life) {
        this.name = name;
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", life=" + life +
                '}';
    }
}
