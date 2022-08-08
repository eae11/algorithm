package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new SelectionSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    //O(n^2)不稳定
    //空间O(1)
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, minIndex, i);
        }
    }

}
