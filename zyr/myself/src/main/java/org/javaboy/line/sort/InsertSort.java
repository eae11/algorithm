package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class InsertSort extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new InsertSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    // 时间复杂度：O(n^2)稳定
    // 空间复杂度：O(1)
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        // 插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            int tmp = data[i];
            int j;
            for (j = i; j >= 1; j--) {
                if (tmp < data[j - 1]) {
                    // 将较大的元素总是向右移动
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            // 找到 i 对应的元素需要插入的位置
            data[j] = tmp;
        }
    }

    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public void sort1(int[] data) {
        if (data == null || data.length <= 1) return;

        // 插入排序的轮数
        for (int i = 1; i < data.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (data[j] < data[j - 1]) {
                    swap(data, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
}
