package org.javaboy.line.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ShellSort extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new ShellSort().sort1(nums);
        System.out.println(Arrays.toString(nums));
    }

    //时间O(n^3/2)不稳定
    //空间O(1);
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        // 1. 计算递增序列
        int n = data.length;
        ArrayList<Integer> list = new ArrayList<>();
        int k = 1;
        int h;
        do {
            h = ((int) Math.pow(3, k) - 1) / 2;
            // bug 修复：需要考虑 n < 3 的场景，
            // 当 n < 3 的时候，不应该 break，而应该将 h 添加到 list 中
            if (h > n / 3 && n >= 3) break;
            list.add(h); // 1, 4, 13, 40, 121......
            k++;
        } while (h <= n / 3);

        for (k = list.size() - 1; k >= 0; k--) {//把h取出来
            h = list.get(k);
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (data[j] < data[j - h]) {
                        swap(data, j - h, j);
                    } else {
                        break;
                    }

                }
            }

        }
    }

    //O(n^2)
    public void sort1(int[] data) {
        if (data == null || data.length <= 1) return;

        // 1. 计算递增序列
        int n = data.length;
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121......

        // 2. 希尔排序
        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < n; i++) {
                int temp = data[i];
                int j;
                for (j = i; j >= h; j = j - h) {
                    if (temp < data[j - h]) {
                        data[j - h] = data[j];
                    } else {
                        break;
                    }
                }
                data[j] = temp;
            }
            h = h / 3;
        }


    }

}
