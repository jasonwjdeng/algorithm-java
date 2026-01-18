package com.example.leetcode;

import java.util.Arrays;

// 674. 最长连续递增序列
// https://leetcode.cn/problems/longest-continuous-increasing-subsequence/
public class Solution674 {
  public int findLengthOfLCIS(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        dp[i] = dp[i - 1] + 1;
        result = Math.max(result, dp[i]);
      } else dp[i] = 1;
    }
    return result;
  }
}
