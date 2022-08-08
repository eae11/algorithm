package org.javaboy.line.sort;

import java.util.Random;

public class SortCompare {
    private static Random random = new Random();

    private static int[] genData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    private static long time(String sortType, int[] data) {
        long start = System.currentTimeMillis();

        if (sortType.equals("bubble")) new BubbleSort().sort(data);
        else if (sortType.equals("selection")) new SelectionSort().sort(data);
        else if (sortType.equals("insertion")) new InsertSort().sort(data);
        else if (sortType.equals("shell")) new ShellSort().sort1(data);

        return System.currentTimeMillis() - start;
    }

    private static long manyTimesSort(String sortType, int n, int k) {
        long totalTime = 0;
        for (int i = 0; i < k; i++) {
            totalTime += time(sortType, genData(n));
        }
        return totalTime;
    }

    public static void main(String[] args) {
        double t1 = manyTimesSort("bubble", 1000, 100);
        double t2 = manyTimesSort("selection", 1000, 100);
        double t3 = manyTimesSort("insertion", 1000, 100);
        double t4 = manyTimesSort("shell", 1000, 100);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        // 结论：插入排序性能最好，其次是选择排序，最后是冒泡排序
    }
}
