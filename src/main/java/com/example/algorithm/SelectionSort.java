package com.example.algorithm;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    // 设置每轮循环的起点
    for (int i = 0; i < nums.length - 1; i++) {
      // 假设起点元素为最小
      int min = i;
      // 遍历数组剩余部分
      for (int j = i + 1; j < nums.length; j++) {
        // 找出最小的元素，记录其下标
        if (less(nums[j], nums[min])) {
          min = j;
        }
        // 当遍历完剩余的元素后，把最小的元素和起点元素交换位置，也即最小的元素被左移
        if (j == nums.length - 1) {
          swap(nums, i, min);
        }
      }
      if (nums.length <= 10) {
        printArray(nums);
      }
    }
  }
}
