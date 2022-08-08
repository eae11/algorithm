package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class CountingSort {
    static Random random = new Random();

    public static void main(String[] args) {
        //int[] nums = {5, 9, 5, 4, 3, 2, 1, 12, 19};
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new CountingSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //稳定
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int length = nums.length;
        int max = nums[0];
        int min = nums[0];
        // 1. 找到数组中的最大值，初始化计数器
        for (int i = 1; i < length; i++) {// O(n)
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int[] count = new int[max - min + 1];
        // 2. 计数
        for (int i = 0; i < length; i++) {// O(n)
            count[nums[i] - min]++;
        }
        // 3. 计数累加
        for (int i = 1; i < count.length; i++) {// O(k)
            count[i] += count[i - 1];
        }
        // 4. 计算每个元素在排序数组中的位置
        int[] outPut = new int[length];
        for (int i = nums.length - 1; i >= 0; i--) {// O(n)
            int num = nums[i];//具体值
            int index = count[num - min] - 1;//索引
            outPut[index] = num;
            count[num - min]--;
        }
        // 5. 拷贝数组
        for (int i = 0; i < length; i++) { // O(n)
            nums[i] = outPut[i];
        }
    }

}
