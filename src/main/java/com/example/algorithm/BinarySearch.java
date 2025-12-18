package com.example.algorithm;

public class BinarySearch {
  public int search(int[] nums, int target) {
    int begin = 0, end = nums.length - 1;
    while (begin <= end) {
      int mid = (begin + end) / 2;
      if (target < nums[mid]) {
        end = mid - 1;
      } else if (target > nums[mid]) {
        begin = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
