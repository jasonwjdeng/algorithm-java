package com.example.algorithm;

public class MergeSort<T extends Comparable<T>> extends Sort<T> {
  T[] aux;

  @Override
  public void sort(T[] nums) {
    // 初始化辅助数组
    aux = (T[]) new Comparable[nums.length];
    sort(nums, 0, nums.length - 1);
  }

  private void sort(T[] nums, int begin, int end) {
//    System.out.println("begin=" + begin + ",end=" + end);
    int len = end - begin + 1;
    if (len <= 1) return;
    // 优化：对小规模数据用插入排序
    if (len < 16) {
//      System.out.println("use insertion sort");
      insertionSort(nums, begin, end);
      return;
    }
    int mid = begin + len / 2;
    sort(nums, begin, mid - 1);
    sort(nums, mid, end);
    // 优化：整个数组已经有序，跳过merge
    if (less(nums[mid - 1], nums[mid])) return;
    merge(nums, begin, mid, end);
  }

  private void merge(T[] nums, int begin, int mid, int end) {
    // 把待排序数据[begin,end]复制到辅助数组
    if (end + 1 - begin >= 0) System.arraycopy(nums, begin, aux, begin, end + 1 - begin);
    // 设置左右两部分起始位置
    int left = begin;
    int right = mid;
    // 遍历所有待排序数据
    for (int i = begin; i <= end; i++) {
      // 当左半部分已耗尽，把右半部分复制到原数组中
      if (left >= mid) nums[i] = aux[right++];
      // 当右半部分已耗尽，把左半部分复制到原数组中
      else if (right > end) nums[i] = aux[left++];
      // 当右半部分的元素比左半部分的小，把右半部分复制到原数组中
      else if (less(aux[right], aux[left])) nums[i] = aux[right++];
      // 把左半部分复制到原数组中
      else nums[i] = aux[left++];
    }
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
