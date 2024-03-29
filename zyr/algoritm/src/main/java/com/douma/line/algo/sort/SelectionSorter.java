package com.douma.line.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class SelectionSorter extends Sorter {
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    static Random random = new Random();
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        for (int i = 0; i < data.length-1; i++) { // 控制选择排序的轮数
            // 找到 [i, n) 中的最小元素所在的索引
            int minNumIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[minNumIndex]) {
                    minNumIndex = j;
                }
            }
            // 将 data[i] 和最小元素进行交换
            swap(data, i, minNumIndex);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        //int[] data = new int[]{12, 23, 36, 9, 24, 42};
        new SelectionSorter().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
