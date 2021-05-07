package com.jetco.core.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 子弹池
 *
 * 享元模式：池化技术，数据库连接池、线程池等
 *
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-19
 */
public class BulletPool {

    List<Bullet> bulletList = new ArrayList<>();

    {
        for(int i = 0; i < 10; i++) {
            bulletList.add(new Bullet());
        }
    }

    public Bullet getBullet() {
        for (Bullet bullet : bulletList) {
            if (!bullet.living) {
                return bullet;
            }
        }
        return new Bullet();
    }

}
