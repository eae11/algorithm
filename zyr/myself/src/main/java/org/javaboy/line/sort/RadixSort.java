package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class RadixSort {
    static Random random = new Random();

    public static void main(String[] args) {
        //int[] nums = {5, 9, 5, 4, 3, 2, 1, 12, 19};
        int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new RadixSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //时间O(n)
    public void sort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int max = nums[0];
        //找到最大值
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        // 2. 对数组按照每个元素的每位进行计数排序
        for (int exp = 1; max / exp > 0; exp *= 10) {
            sort(nums, exp);
        }
    }

    //使用计数排序来给每一位进行排序
    private void sort(int[] nums, int exp) {//时间复杂度：O(n+k) O(n+10)=>O(n)
        // 之所以是 10，是因为数字只有 0...9 十个数字
        //初始化计数器
        int[] count = new int[10];
        for (int i = 0; i < nums.length; i++) {
            // 个位数： (234 / 1) % 10 = 4
            // 十位数： (234 / 10) % 10 = 3
            // 百位数： (234 / 100) % 10 = 2
            int digit = (nums[i] / exp) % 10;//从个位开始对每一位进行排序
            count[digit]++;
        }
        // 3. 计数累加
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int digit = (nums[i] / exp) % 10;
            int index = count[digit] - 1;
            output[index] = nums[i];
            count[digit]--;
        }

        for (int i = 0; i < nums.length; i++) { // O(n)
            nums[i] = output[i];
        }

    }
}
