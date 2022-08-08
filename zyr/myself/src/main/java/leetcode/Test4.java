package leetcode;

import java.util.Arrays;

/*
给定一个数组nums，编写一个算法实现以下的功能:
将数组nums 中所有等于0元素移动到数组的末端
同时要保持非零元素的相对顺序

*/
public class Test4 {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 6, 2, 3, 8, 9};
        new Test4().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (slow != fast) { // 减少赋值的次数
                    nums[slow] = nums[fast];
                }
                slow++;
            }
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }

    // 双指针实现（快慢指针）
    // 时间复杂度 O(n)
    // 空间复杂度 O(1)
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                if (slow != fast) { // 减少交换的次数
                    // 交换 fast 和 slow 指向的元素
                    int tmp = nums[fast];
                    nums[fast] = nums[slow];
                    nums[slow] = tmp;
                }
                slow++;
            }
        }
    }

    // 时间复杂度 O(n)
    // 空间复杂度 O(n)
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] tmp = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp[j] = nums[i];
                j++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }
}
