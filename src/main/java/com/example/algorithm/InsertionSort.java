package com.example.algorithm;

public class InsertionSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    // 设置每轮循环需要待插入的元素下标
    for (int i = 1; i < nums.length; i++) {
      // 待插入元素与前面已排序的元素一一比较，比前面元素小的就交换位置
      // 直到找到不大于待插入元素的位置后退出本轮循环
      for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
        swap(nums, j, j - 1);
        //        printArray(nums);
      }
      if (nums.length <= 10) {
        printArray(nums);
      }
    }
  }
}
