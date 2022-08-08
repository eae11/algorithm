package org.javaboy.line.linkedList;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E> {
    private Node first;//头节点
    private Node last;//尾节点
    private int size;

    public DoubleLinkedList() {
        first = last = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        Node node = node(index);
        if (node == null) {
            throw new IllegalArgumentException("index failed, index must >= 0 and < size");
        }
        return node.e;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private Node node(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index < size / 2) {
            Node curr = first;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        } else {
            Node curr = last;
            for (int i = size - 1; i > index; i--) {
                curr = last.prev;
            }
            return curr;
        }
    }

    public void set(int index, E e) {
        Node node = node(index);
        if (node == null) {
            throw new IllegalArgumentException("index failed, index must >= 0 and < size");
        }
        node.e = e;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add failed, index must >= 0 and <= size");
        }
        if (index == size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            Node behind = node(index);
            Node prev = behind.prev;
            Node curr = new Node(prev, e, behind);
            prev.next = curr;
            behind.prev = curr;
            size++;
        }


    }

    public void addFirst(E e) {
        if (first == null) {
            first = new Node(null, e, null);
            last = first;
        } else {
            Node curr = new Node(null, e, first);
            first.prev = curr;
            first = curr;
        }
        size++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (last == null) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            newNode.prev = last;
            last = newNode;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, index must >= 0 and < size");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node node = node(index);
            E e = node.e;
            Node prev = node.prev;
            Node behind = node.next;
            prev.next = behind;
            behind.prev = prev;

            node.prev = null;
            node.next = null;
            size--;
            return e;
        }

    }

    public E removeFirst() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        E e = first.e;
        Node next = first.next;
        if (next == null) {
            first = null;
            last = null;
        } else {
            next.prev = null;
            first.next = null;
            first = next;
        }
        size--;
        return e;
    }

    public E removeLast() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        E e = last.e;
        Node prev = last.prev;
        if (prev == null) {
            first = null;
            last = null;
        } else {
            prev.next = null;
            last.prev = null;
            last = prev;
        }
        size--;
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (first != null) {
            sb.append(first + "=>");
            Node curr = first.next;
            while (curr != null) {
                sb.append(curr + "=>");
                curr = curr.next;
            }
        }

        sb.append("null");
        return sb.toString();
    }

    private class Node {
        E e;
        Node prev;
        Node next;

        public Node(Node prev, E e, Node next) {
            this.e = e;
            this.next = next;
            this.prev = prev;
        }

        public Node(E e) {
            this(null, e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
