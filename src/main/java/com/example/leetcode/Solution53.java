package com.example.leetcode;

// 53.最大子数组和
// https://leetcode.cn/problems/maximum-subarray
public class Solution53 {
  public int maxSubArray(int[] nums) {
    int sum = Integer.MIN_VALUE;
    int s = 0;
    for (int n : nums) {
      s += n;
      sum = Math.max(s, sum);
      if (s < 0) s = 0;
    }
    return sum;
  }
}
