package com.jetco.core.behavioral.iterator;

import java.util.List;

/**
 * <p>
 * 链表实现list
 * </p>
 *
 * @author lhw
 * @version 1.0
 * @since 2021-04-20
 */
public class LinkedList<E> implements Collection<E> {

    Node head = null;

    Node tail = null;

    //目前容器中有多少个元素
    private int size = 0;

    Node node;

    @Override
    public void add(E e) {
        node = new Node(e);
        if(head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    class Node<E> {
        private E e;
        Node next;
        public Node(E e) {
            this.e = e;
        }
    }

    class LinkedListIterator implements Iterator<E>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

}
