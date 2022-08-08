package org.javaboy.line.search;

public class BinarySearch {
    public static void main(String[] args) {

    }

    public int firstTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                if (mid == 0 || target != nums[mid - 1]) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int lastTargetElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target == nums[mid]) {
                if (mid == nums.length - 1 || target != nums[mid + 1]) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
