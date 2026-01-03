package com.example.leetcode;

import java.util.Arrays;

// 746. 使用最小花费爬楼梯
// https://leetcode.cn/problems/min-cost-climbing-stairs/
public class Solution746 {
  public int minCostClimbingStairs(int[] cost) {
    int[] dp = new int[cost.length + 1];
    dp[0] = 0; // 到第1级之前的成本
    dp[1] = 0; // 到第2级之前的成本
    // 计算到第i级之前的成本
    for (int i = 2; i <= cost.length; i++) {
      // 到第i级之前的成本=min(到第i-2级之前的成本+第i-2级的成本,到第i-1级之前的成本+第i-1级的成本)
      dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
    }
    // 到顶部的成本
    return dp[cost.length];
  }

  public int minCostClimbingStairs2(int[] cost) {
    int[] dp = new int[cost.length];
    dp[0] = cost[0]; // 第1级的成本
    dp[1] = cost[1]; // 第2级的成本
    // 计算第i级的成本
    for (int i = 2; i < dp.length; i++) {
      // 第i级的成本=min(第i-2级的成本+第i级的成本,第i-1级的成本+第i级的成本)
      dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
    }
    // 算出倒数第2和第1级的成本的最小值，即为最终结果
    // 因为只需要再走2或者1级就到达顶部
    return Math.min(dp[cost.length - 2], dp[cost.length - 1]);
  }

  public static void main(String[] args) {
    Solution746 solution = new Solution746();
    System.out.println(solution.minCostClimbingStairs(new int[] {10, 15, 20})); // 15
    System.out.println(
        solution.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
    System.out.println(solution.minCostClimbingStairs2(new int[] {10, 15, 20})); // 15
    System.out.println(
        solution.minCostClimbingStairs2(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1})); // 6
  }
}
