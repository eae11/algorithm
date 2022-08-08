
package org.javaboy.line.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayStackTest {
    public static void main(String[] args) {
        //ArrayStack<Integer> stack = new ArrayStack<>(10);
        //DynamicArrayStack<Integer> stack = new DynamicArrayStack(10);
        //Deque<Integer> stack = new ArrayDeque<>();
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        System.out.println(stack);
        stack.push(20);
        System.out.println(stack);
        stack.push(30);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
