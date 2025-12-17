package com.example.algorithm;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    sort(nums, 0, nums.length - 1);
  }

  private void sort(T[] nums, int begin, int end) {
    if (begin >= end) return;
    // 优化：对小规模数据用插入排序
    if (end - begin < 16) {
//      System.out.println("use insertion sort");
      insertionSort(nums, begin, end);
      return;
    }
    // 根据基准元素pivot进行分区，小于pivot的元素在左边，大于等于pivot的元素在右边
    int index = partition(nums, begin, end);
    // 对左右两边的元素分别进行排序
    sort(nums, begin, index - 1);
    sort(nums, index + 1, end);
  }

  private int partition(T[] nums, int begin, int end) {
    // 初始化分区索引指向基准元素（第一个元素为基准元素pivot）
    int index = begin;
    for (int i = begin + 1; i <= end; i++) {
      // 遇到小于pivot的元素，index右移一位，将该元素交换到index位置
      if (less(nums[i], nums[begin])) {
        index++;
        swap(nums, i, index);
      }
    }
    // 迭代完成后，所有小于pivot的元素都在[begin+1,index]区间中
    // 将基准元素begin交换到分区索引index位置
    // 这时候index左边[begin,index-1]的元素都小于pivot
    // index右边[index+1,end]的元素都大于或等于pivot
    if (index != begin) swap(nums, begin, index);
    return index;
  }

  private void insertionSort(T[] nums, int begin, int end) {
    for (int i = begin; i <= end; i++) {
      for (int j = i; j > begin && less(nums[j], nums[j - 1]); j--) {
        swap(nums, j, j - 1);
      }
    }
    if (nums.length <= 10) {
      printArray(nums);
    }
  }
}
