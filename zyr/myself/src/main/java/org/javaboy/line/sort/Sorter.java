package org.javaboy.line.sort;

public abstract class Sorter {
    /*总结：不稳定的排序：堆排序，快速排序，希尔排序，选择排序。
           稳定的排序：冒泡排序，插入排序，归并排序，基数排序。*/
    public <T> void swap(T[] nums, int i, int j) {
        T tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swap(Integer[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
