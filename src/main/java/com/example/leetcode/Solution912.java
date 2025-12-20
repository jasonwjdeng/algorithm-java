package com.example.leetcode;

public class Solution912 {
  public int[] sortArray(int[] nums) {
    threeWayQuickSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void threeWayQuickSort(int[] nums, int begin, int end) {
    if (begin >= end) return;
    if (end - begin < 15) {
      insertionSort(nums, begin, end);
      return;
    }
    int lt = begin, gt = end;
    int pivot = nums[begin];
    int i = begin;
    while (i <= gt) {
      if (nums[i] < pivot) {
        swap(nums, i++, lt++);
      } else if (nums[i] > pivot) {
        swap(nums, i, gt--);
      } else {
        i++;
      }
    }
    threeWayQuickSort(nums, begin, lt - 1);
    threeWayQuickSort(nums, gt + 1, end);
  }

  private void insertionSort(int[] nums, int begin, int end) {
    for (int i = begin; i <= end; i++) {
      for (int j = i; j > begin && nums[j] < nums[j - 1]; j--) {
        swap(nums, j, j - 1);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
