package org.javaboy.line.search;

public class BasicBinarySearch {
    public static void main(String[] args) {

    }

    // 时间复杂度：O(logn)
    // 空间复杂度：O(1)
    public boolean contains(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        // bug ：left + right 会溢出
        // 整数的最大值：2^31 - 1 = 2147483647
        //int mid = (left + right) / 2;
        //int mid = left + (right - left) / 2;
        int mid = (left + right) >>> 1;
        while (left <= right) {
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    //递归写法
    public boolean containsR(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return containsR(nums, 0, nums.length - 1, target);
    }

    private boolean containsR(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) >>> 1;
        if (target == nums[mid]) {
            return true;
        } else if (target < nums[mid]) {
            return containsR(nums, 0, mid - 1, target);
        } else {
            return containsR(nums, mid + 1, right, target);
        }

    }
}
