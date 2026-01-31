package com.example.leetcode;

import java.util.Arrays;

// 279. 完全平方数
// https://leetcode.cn/problems/perfect-squares/
public class Solution279 {
  public int numSquares(int n) {
    // dp[j]表示和为j的完全平方数的最小数目
    int[] dp = new int[n + 1];
    // 因为递推公式要求最小值，所以初始化为最大值
    Arrays.fill(dp, Integer.MAX_VALUE);
    // 什么数字都不选和就为0
    dp[0] = 0;
    // 先遍历物品
    for (int i = 1; i * i <= n; i++) {
      // 再遍历背包
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
