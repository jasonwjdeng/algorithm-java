package com.example.leetcode;

import java.util.Arrays;

// 674. 最长连续递增序列
// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
public class Solution674 {
  public int findLengthOfLCIS(int[] nums) {
    int result = 1;
    int pre = 1, cur = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        cur = pre + 1;
        result = Math.max(result, cur);
      } else cur = 1;
      pre = cur;
    }
    return result;
  }
}
