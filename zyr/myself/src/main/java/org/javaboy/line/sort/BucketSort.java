package org.javaboy.line.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BucketSort {
    static Random random = new Random();
    InterQuickSort sort = new InterQuickSort();

    public static void main(String[] args) {
        int[] nums = new int[1_000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(10000) + 1;
        }
        new BucketSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //O(nlog(n/m))    m桶的个数  n数组的长度 当n≈m  =>O(n) 桶排序是否稳定取决于给桶内排序时的算法是否稳定
    //空间O(1)
    public void sort(int[] data) {
        if (data == null || data.length <= 1) return;

        int maxValue = 0;
        for (int d : data) {
            maxValue = Math.max(maxValue, d);
        }
        int bucketNum = maxValue / 10 + 1;
        //桶里的数据个数不一样,用动态数组
        ArrayList<Integer>[] buckets = new ArrayList[bucketNum];
        // 2. 将所有的元素添加进对应的 bucket
        for (int i = 0; i < data.length; i++) {
            int index = data[i] / 10;//计算出放到哪个桶里
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(data[i]);
        }
        // 3. 对每一个 bucket 中的元素进行排序
        for (int i = 0; i < bucketNum; i++) {
            sort.sort(buckets[i]);
        }
        // 4. 从 buckets 中拿到排序后的数组
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (Integer num : bucket) {
                    data[index++] = num;
                }
            }

        }
    }
}
