package com.example.leetcode;

public class Solution75 {
  public void sortColors(int[] nums) {
    int lt = 0;
    int gt = nums.length - 1;
    int i = 0;
    while (i <= gt) {
      if (nums[i] == 0) {
        // swap(nums, i++, lt++);
        nums[i++] = nums[lt];
        nums[lt++] = 0;
      } else if (nums[i] == 2) {
        // swap(nums, i, gt--);
        nums[i] = nums[gt];
        nums[gt--] = 2;
      } else {
        i++;
      }
    }
  }
}
