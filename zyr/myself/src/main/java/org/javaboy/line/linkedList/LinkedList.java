package org.javaboy.line.linkedList;

public class LinkedList<E> {
    private Node dummyHead;//  head -> node-> node->node->node size 4
    private int size;         //         0       1    2      3

    public LinkedList() {
        this.dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index must >= 0 and < size");

        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, index must >= 0 and < size");
        }

        Node prev = dummyHead;
        Node behind;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        behind = prev.next;
        prev.next = new Node(e, behind);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get failed, index must >= 0 and < size");
        }
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.e = e;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed, index must >= 0 and < size");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;

    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        if (size == 0) {
            throw new IllegalArgumentException("removeElement failed, LinkedList is Empty");
        }
        Node prev = dummyHead;
        Node curr = dummyHead.next;
        while (curr != null) {
            if (curr.e.equals(e)) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) {
            prev.next = curr.next;
            curr.next = null;
        }
    }

    public boolean contains(E e) {
        Node curr = dummyHead;
        while (curr.next != null) {
            curr = curr.next;
            if (curr.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node curr = dummyHead.next;
        while (curr != null) {
            sb.append(curr + "=>");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }

    private class Node {
        Node next;
        E e;

        public Node(E e, Node next) {
            this.next = next;
            this.e = e;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


}
