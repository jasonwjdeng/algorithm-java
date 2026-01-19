package com.example.leetcode;

import java.util.Arrays;

// 674. 最长连续递增序列
// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
public class Solution674 {
  public int findLengthOfLCIS(int[] nums) {
    int result = 1;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        count++;
        result = Math.max(result, count);
      } else count = 1;
    }
    return result;
  }
}
