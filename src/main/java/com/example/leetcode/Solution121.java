package com.example.leetcode;

// 121. 买卖股票的最佳时机
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
public class Solution121 {
  // 贪心算法
  public int maxProfit(int[] prices) {
    int profit = 0;
    //    int cost = Integer.MAX_VALUE;
    int cost = 10001;
    for (int price : prices) {
      // 找出最低成本
      cost = Math.min(cost, price);
      // 找出最大利润
      profit = Math.max(profit, price - cost);
    }
    return profit;
  }

  public int maxProfit1D(int[] prices) {
    // dp[0]表示买入股票后持有的现金
    // dp[1]表示卖出股票后持有的现金
    int[] dp = new int[2];
    // 初始化dp数组
    dp[0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[0] = Math.max(dp[0], -prices[i]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[1] = Math.max(dp[1], dp[0] + prices[i]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[1];
  }

  public int maxProfit2D(int[] prices) {
    // dp[i][0]表示买入股票后持有的现金
    // dp[i][1]表示卖出股票后持有的现金
    int[][] dp = new int[prices.length][2];
    // 初始化dp数组
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    for (int i = 1; i < prices.length; i++) {
      // 买入股票后持有的现金，要么之前就买入，要么现在买入
      dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
      // 卖出股票后持有的现金，要么之前就卖出，要么现在卖出
      dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    }
    // 最后卖出股票后持有的现金就是答案
    return dp[prices.length - 1][1];
  }
}
