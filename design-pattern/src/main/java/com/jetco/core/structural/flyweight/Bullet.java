package com.jetco.core.structural.flyweight;

import java.util.UUID;

/**
 * <p>
 * 子弹
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class Bullet {

    public UUID id = UUID.randomUUID();

    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}
