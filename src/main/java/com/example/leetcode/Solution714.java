package com.example.leetcode;

// 714. 买卖股票的最佳时机含手续费
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class Solution714 {
  public int maxProfit(int[] prices, int fee) {
    // dp[0]表示买入股票后持有的现金
    // dp[1]表示卖出股票后持有的现金
    int[] dp = new int[2];
    // 初始化dp数组
    dp[0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[0] = Math.max(dp[0], dp[1] - prices[i]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[1] = Math.max(dp[1], dp[0] + prices[i] - fee);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[1];
  }

  public int maxProfit2D(int[] prices, int fee) {
    // dp[i][0]表示买入股票后持有的现金
    // dp[i][1]表示卖出股票后持有的现金
    int[][] dp = new int[prices.length][2];
    // 初始化dp数组
    dp[0][0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[prices.length - 1][1];
  }
}
