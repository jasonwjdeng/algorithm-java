package com.example.algorithm;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    // 计算每次循环的起始增量，每次循环后增量减半
    for (int step = nums.length / 2; step >= 1; step /= 2) {
//      System.out.println("step=" + step);
      // 设置每轮循环需要待插入的元素下标
      for (int i = step; i < nums.length; i += step) {
        // 待插入元素与前面已排序的元素一一比较，比前面元素小的就交换位置
        // 直到找到不大于待插入元素的位置后退出本轮循环
        for (int j = i; j > 0 && less(nums[j], nums[j - step]); j -= step) {
          swap(nums, j, j - step);
          //        printArray(nums);
        }
        if (nums.length <= 10) {
          printArray(nums);
        }
      }
    }
  }
}
