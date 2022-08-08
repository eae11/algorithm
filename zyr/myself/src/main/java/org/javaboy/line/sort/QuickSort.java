package org.javaboy.line.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort extends Sorter {
    static Random random = new Random();

    public static void main(String[] args) {
        long start = System.nanoTime();
        int[] nums = new int[1_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        //int[] nums = new int[]{34, 33, 12, 78, 21, 1, 98, 100};
        new QuickSort().sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println((System.nanoTime() - start) / 1000_000_000.0);
    }
    //空间O(log2n)
    //时间O(nlog2n)
    //不稳定
    public void sort(int[] data) {
        if (data == null || data.length < 2) return;
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //返回分区完中间数的索引
        int j = partition(data, lo, hi);
        sort(data, lo, j - 1);
        sort(data, j + 1, hi);

    }

    private int partition(int[] data, int lo, int hi) {
        //选取最后一个作为比较对象
        int pivot = data[hi];
        int j = hi;
        //循环的次数
        //注意这里不能直接写hi,因为里面hi--,会影响到循环的次数
        for (int i = lo; i < j; i++) {
            if (data[i] <= pivot) {
                data[lo] = data[i];
                lo++;
            } else {
                data[hi] = data[i];
                hi--;
            }
        }
        data[lo] = pivot;
        return lo;
    }
}
