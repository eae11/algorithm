package org.javaboy.line.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InterQuickSort {
    static Random r = new Random();

    public static void main(String[] args) {
        long start = System.nanoTime();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(r.nextInt(1000));
        }
        new InterQuickSort().sort(list);
        System.out.println(list);

        System.out.println((System.nanoTime() - start) / 1000_000_000.0);
    }

    //空间O(log2n)
    //时间O(nlog2n)
    //不稳定
    public void sort(List<Integer> data) {
        if (data == null || data.size() < 2) return;
        sort(data, 0, data.size() - 1);
    }

    private void sort(List<Integer> data, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        //返回分区完中间数的索引
        int j = partition(data, lo, hi);
        sort(data, lo, j - 1);
        sort(data, j + 1, hi);

    }

    private int partition(List<Integer> data, int lo, int hi) {
        //选取最后一个作为比较对象
        int pivot = data.get(hi);
        int j = hi;
        //循环的次数
        //注意这里不能直接写hi,因为里面hi--,会影响到循环的次数
        for (int i = lo; i < j; i++) {
            if (data.get(i) <= pivot) {
                data.set(lo, data.get(i));
                lo++;
            } else {
                data.set(hi, data.get(i));
                hi--;
            }
        }
        data.set(lo, pivot);
        return lo;
    }
}
