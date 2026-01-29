package com.example.leetcode;

import java.util.Arrays;

// 279. 完全平方数
// https://leetcode.cn/problems/perfect-squares/
public class Solution279 {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i * i <= n; i++) {
      for (int j = i * i; j <= n; j++) {
        dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
      }
    }
    //    System.out.println(Arrays.toString(dp));
    return dp[n];
  }

  public static void main(String[] args) {
    Solution279 solution = new Solution279();
    System.out.println(solution.numSquares(12)); // 3
    System.out.println(solution.numSquares(13)); // 2
  }
}
