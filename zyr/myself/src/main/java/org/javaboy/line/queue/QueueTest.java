package org.javaboy.line.queue;

import java.util.LinkedList;

public class QueueTest {
    public static void main(String[] args) {
        //java提供的默认实现的双端队列两个ArrayDeque(循环队列实现)和LinkedList(双向链表) 也提供了push() pop()来模拟栈

        /*
        add和offer方法的作用都是入队，它们的区别是:
1.如果队列的容量是没有限制的，那么使用add和offer效果一样
2.如果队列的容量是有限制的，那么∶
    1.当队列还没有满的时候，add和offer效果一样
    2.当队列已经满了，调用add 的时候会抛llegalStateException异常
而offer不会抛异常，只是返回false

remove和poll方法的作用都是出队，它们的区别在于队列为空的时候:
1.对空队列进行remove会抛NoSuchElementException异常
2.对空队列进行poll则返回null


element和peek方法的作用都是看一眼队首元素，它们的区别在于队列为空的时候:
1.对空队列进行element 会抛 NoSuchElementException异常
2.对空队列进行peek 则返回null

        */
        java.util.Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(10);
        System.out.println(queue);

        queue.addFirst(20);
        System.out.println(queue);

        queue.addFirst(30);
        System.out.println(queue);

        queue.removeLast();
        System.out.println(queue);

        queue.removeLast();
        System.out.println(queue);
    }
}
