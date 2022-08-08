package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new BubbleSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //O(n^2)稳定
    //空间O(1)
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;
        for (int i = 0; i < data.length - 1; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    hasSwap = true;
                    swap(data, j, j + 1);
                }
            }
            //没有交换说明已经有序了
            if (!hasSwap) {
                return;
            }
        }
    }
}
