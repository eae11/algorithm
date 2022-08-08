package org.javaboy.line.stack;

import java.util.Random;


public class PerformanceTest {
    private static Random random = new Random();

    private static double testStack(Stack<Integer> stack, int cnt) {
        long startTime = System.nanoTime();

        for (int i = 0; i < cnt; i++) {
            stack.push(random.nextInt());
        }
        for (int i = 0; i < cnt; i++) {
            stack.pop();
        }

        return (System.nanoTime() - startTime) / 1000_000_000.0;
    }

    public static void main(String[] args) {
        int cnt = 100000000;
        //int cnt = 1000000;

        Stack<Integer> stack = new DynamicArrayStack<>(10);
        double time1 = testStack(stack, cnt);
        System.out.println("DynamicArrayStack 花费的时间：" + time1);//37秒

        stack = new LinkedListStack<>();
        double time2 = testStack(stack, cnt);
        System.out.println("LinkedListStack 花费的时间：" + time2);//92秒
    }


}
