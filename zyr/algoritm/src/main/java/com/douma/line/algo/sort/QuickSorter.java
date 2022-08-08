package com.douma.line.algo.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @微信公众号 : 抖码课堂
 * @官方微信号 : bigdatatang01
 * @作者 : 老汤
 */
public class QuickSorter extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = new int[1_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        //int[] nums = new int[]{34, 33, 12, 78, 21, 1, 98, 100};
        new QuickSorter().sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println((System.nanoTime()-start)/1000_000_000.0);
    }
    //空间O(logn)
    //时间O(nlogn)
    //不稳定
    public void sort(int[] data) {
        if (data == null || data.length < 2) return;
        sort(data, 0, data.length - 1);
    }

    // 子问题
    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) return;
        // 分区
        int j = partition(data, lo, hi);
        // 对左边数组排序
        sort(data, lo, j - 1);// log2n
        // 对右边数组排序
        sort(data, j + 1, hi); // log2n
    }

    private int partition(int[] data, int lo, int hi) {
        //不如我自己写的
        int pivot = data[hi];
        int less = lo;
        int great = lo;
        for (; great <= hi - 1; great++) {
            if (data[great] < pivot) {
                swap(data, less, great);
                less++;
            }
        }
        swap(data, less, hi);
        return less;
    }
}
