package org.javaboy.line.linkedList;

public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> link = new DoubleLinkedList<>();
        link.add(0, 5);
        link.add(1, 6);
        link.remove(0);
        link.addLast(9);
        link.removeLast();
        System.out.println(link);

    }
}
