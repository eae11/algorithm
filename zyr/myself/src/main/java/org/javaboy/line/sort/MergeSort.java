package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    static Random random = new Random();

    public static void main(String[] args) {
        /*int[] nums = new int[10_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }*/
        int[] nums = {9, 4, 7, 5, 4, 5, 445, 4, 6, 64, 4165, 45, 77465, 11};
        new MergeSort().sort(nums);
        new MergeSort().sortBU(nums);
        System.out.println(Arrays.toString(nums));
    }

    //T=O(nlog2n)稳定
    //空间O(n)
    public void sort(int[] data) {
        if (data == null || data.length < 2) return;
        int[] tmp = new int[data.length];
        sort(data, 0, data.length - 1, tmp);
        //System.out.println(Arrays.toString(tmp));
    }

    private void sort(int[] data, int left, int right, int[] tmp) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(data, left, mid, tmp);
        sort(data, mid + 1, right, tmp);
        // 合并两个有序的数组，即合并 [left...mid] 和 [mid + 1, right]
        merge(data, left, mid, right, tmp);
    }

    private void merge(int[] data, int left, int mid, int right, int[] tmp) {
        int t = left;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (data[i] < data[j]) {
                tmp[t] = data[i];
                t++;
                i++;
            } else {
                tmp[t] = data[j];
                t++;
                j++;
            }
        }
        while (i <= mid) {
            tmp[t++] = data[i++];
        }
        while (j <= right) {
            tmp[t++] = data[j++];
        }
        //拷贝
        for (t = left; t <= right; t++) {
            data[left++] = tmp[t];
        }
    }

    //自底向上
    public void sortBU(int[] data) {
        if (data == null || data.length <= 1) return;
        int len = data.length;
        int[] tmp = new int[len];
        for (int size = 1; size < len; size += size) { // size 表示子数组的长度，1,2,4,8
            for (int left = 0; left < len - size; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min(left + 2 * size - 1, len - 1);
                merge(data, left, mid, right, tmp);
            }
        }
    }
}
