package com.example.leetcode;

// 309. 买卖股票的最佳时机含冷冻期
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class Solution309 {
  public int maxProfit(int[] prices) {
    if (prices.length < 2) return 0;
    // dp[i][0]表示买入股票后持有的现金
    // dp[i][1]表示卖出股票后持有的现金
    int[][] dp = new int[prices.length + 1][2];
    // 初始化dp数组
    dp[1][0] = -prices[0];
    for (int i = 2; i <= prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入，但至少1天前卖出才行
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i - 1]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i - 1]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[prices.length][1];
  }

  public int maxProfit2(int[] prices) {
    if (prices.length < 2) return 0;
    // dp[i][0]表示买入股票后持有的现金
    // dp[i][1]表示卖出股票后持有的现金
    int[][] dp = new int[prices.length][2];
    // 初始化dp数组
    dp[0][0] = -prices[0];
    dp[1][0] = Math.max(dp[0][0], -prices[1]);
    dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
    for (int i = 2; i < prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入，但至少1天前卖出才行
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[prices.length - 1][1];
  }
}
