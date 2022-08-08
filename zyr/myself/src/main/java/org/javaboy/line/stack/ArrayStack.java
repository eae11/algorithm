package org.javaboy.line.stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private E[] data;
    private int size;

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E e) {
        if (size == data.length) {
            throw new RuntimeException("push failed, Stack is full");
        }
        data[size++] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("pop failed, stack is empty");
        }
        E e = data[size - 1];
        size--;
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("peek failed, stack is empty");
        }
        return data[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:[");
        for (int i = 0; i < size; i++) {
            if (i != size - 1) {
                sb.append(data[i] + "->");
            } else {
                sb.append(data[i]);
            }
        }
        sb.append("]top");
        return sb.toString();
    }
}
