package com.example.leetcode;

// 123. 买卖股票的最佳时机 III
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
public class Solution123 {
  public int maxProfit(int[] prices) {
    // dp[0]表示交易一次后买入股票后持有的现金
    // dp[1]表示交易一次后卖出股票后持有的现金
    // dp[2]表示交易两次后买入股票后持有的现金
    // dp[3]表示交易两次后卖出股票后持有的现金
    int[] dp = new int[4];
    // 初始化dp数组
    dp[0] = -prices[0];
    dp[2] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 交易一次后买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[0] = Math.max(dp[0], -prices[i]);
      // 交易一次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[1] = Math.max(dp[1], dp[0] + prices[i]);
      // 交易两次后买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[2] = Math.max(dp[2], dp[1] - prices[i]);
      // 交易两次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[3] = Math.max(dp[3], dp[2] + prices[i]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[3];
  }

  public int maxProfit2D(int[] prices) {
    // dp[i][0]表示交易一次后买入股票后持有的现金
    // dp[i][1]表示交易一次后卖出股票后持有的现金
    // dp[i][2]表示交易两次后买入股票后持有的现金
    // dp[i][3]表示交易两次后卖出股票后持有的现金
    int[][] dp = new int[prices.length][4];
    dp[0][0] = -prices[0];
    dp[0][2] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 交易一次后买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
      // 交易一次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
      // 交易两次后买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
      // 交易两次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[prices.length - 1][3];
  }
}
