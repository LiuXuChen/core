package com.jetco.core.behavioral.iterator;

import java.util.List;

/**
 * <p>
 * 数组实现list
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public class ArrayList<E> implements Collection<E> {

    E[] objects = (E[]) new Object[10];

    // objects下一个空的位置在哪儿，或者说目前容器中有多少个元素
    private int index = 0;

    @Override
    public void add(E o) {
        // 扩容判断
        if(index == objects.length) {
            // 扩容2倍
            E[] newObjects = (E[]) new Object[objects.length*2];
            // 将objects元素复制到newObjects
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            // 将objects的内存地址指向newObjects
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public E next() {
            E o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }
}
