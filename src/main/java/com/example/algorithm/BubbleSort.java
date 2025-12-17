package com.example.algorithm;

public class BubbleSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    boolean sorted = false;
    // 设置每轮循环的终点
    // 当终点前移到第一个元素，或者待排序部分已经有序的时候终止循环
    for (int j = nums.length - 1; j > 0 && !sorted; j--) {
      sorted = true;
      // 从头开始遍历每个元素
      for (int i = 0; i < j; i++) {
        // 比较相邻两个元素，把大的元素往后移动
        if (less(nums[i + 1], nums[i])) {
          swap(nums, i, i + 1);
          sorted = false;
        }
      }
      if (nums.length <= 10) {
        printArray(nums);
      }
    }
  }
}
