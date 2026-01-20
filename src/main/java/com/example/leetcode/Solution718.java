package com.example.leetcode;

// 718. 最长重复子数组
// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
public class Solution718 {
  public int findLength(int[] nums1, int[] nums2) {
    int[] dp = new int[nums2.length + 1];
    int result = 0;
    for (int i = 1; i <= nums1.length; i++) {
      for (int j = nums2.length; j > 0; j--) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[j] = dp[j - 1] + 1;
          result = Math.max(result, dp[j]);
        } else dp[j] = 0;
      }
    }
    return result;
  }

  public int findLength2(int[] nums1, int[] nums2) {
    int[][] dp = new int[nums1.length + 1][nums2.length + 1];
    int result = 0;
    for (int i = 1; i <= nums1.length; i++) {
      for (int j = 1; j <= nums2.length; j++) {
        if (nums1[i - 1] == nums2[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(result, dp[i][j]);
        }
      }
    }
    return result;
  }

  public int findLength3(int[] nums1, int[] nums2) {
    int count = 0;
    int result = 0;
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        if (nums1[i] == nums2[j]) count++;
        else {
          result = Math.max(result, count);
          count = 0;
        }
      }
    }
    return result;
  }
}
