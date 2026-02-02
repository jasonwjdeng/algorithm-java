package com.example.leetcode;

// 188. 买卖股票的最佳时机 IV
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
public class Solution188 {
  // 由“123. 买卖股票的最佳时机 III”改写而成
  public int maxProfit(int k, int[] prices) {
    // dp[2k-2]表示交易k次后买入股票后持有的现金
    // dp[2k-1]表示交易k次后卖出股票后持有的现金
    int[] dp = new int[2 * k];
    // 初始化dp数组
    for (int i = 0; i < 2 * k; i += 2) {
      dp[i] = -prices[0];
    }
    for (int i = 1; i < prices.length; i++) {
      // 交易一次后买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[0] = Math.max(dp[0], -prices[i]);
      // 交易一次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[1] = Math.max(dp[1], dp[0] + prices[i]);
      for (int j = 2; j < 2 * k; j += 2) {
        // 交易k次后买入股票后持有的现金，要么之前就买入，要么现在买入
        dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
        // 交易k次后卖出股票后持有的现金，要么之前就卖出，要么现在卖出
        dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
      }
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[2 * k - 1];
  }
}
