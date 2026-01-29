package com.example.leetcode;

// 518. 零钱兑换 II
// https://leetcode.cn/problems/coin-change-ii/
public class Solution518 {
  public int change(int amount, int[] coins) {
    // dp[j]表示给定coins凑成j金额的所有组合的数量
    int[] dp = new int[amount + 1];
    // 初始化dp
    // dp[0]表示给定coins凑成0的组合数，那只有一种组合，就是0个coins
      dp[0] = 1;
    // 从第0个coins开始遍历
    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <=amount; j++) {
          dp[j] += dp[j - coins[i]] ;
      }
    }
    // 结果就是给定coins能组成amount金额的所有组合数量
    return dp[amount];
  }
  public int change2D(int amount, int[] coins) {
    // dp[i][j]表示coins[0-i]凑成j金额的所有组合的数量
    int[][] dp = new int[coins.length][amount + 1];
    // 初始化dp
    // dp[i][0]表示每种coins凑成0的组合数，那只有一种组合，就是0个coins
    for (int i = 0; i < coins.length; i++) {
      dp[i][0] = 1;
    }
    // dp[0][j]表示第0个coins组成j金额的所有组合数量
    for (int j = coins[0]; j <= amount; j++) {
      dp[0][j] = dp[0][j - coins[0]];
    }
    // 从第1个coins开始遍历
    for (int i = 1; i < coins.length; i++) {
      // 从金额0开始遍历
      for (int j = 1; j <= amount; j++) {
        // 如果j < coins[i]，则不取第i个coins，所以等于dp[i - 1][j]
        if (j < coins[i]) dp[i][j] = dp[i - 1][j];
        // 如果j >= coins[i]
        // 不取第i个coins，组合数等于dp[i - 1][j]
        // 取第i个coins，组合数等于dp[i][j - coins[i]]
        // 综上，所有组合之和就是dp[i][j - coins[i]] + dp[i - 1][j]
        else dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
      }
    }
    // 结果就是给定coins能组成amount金额的所有组合数量
    return dp[coins.length - 1][amount];
  }

  public static void main(String[] args) {
    Solution518 solution = new Solution518();
    System.out.println(solution.change2D(5, new int[] {1, 2, 5})); // 4
    System.out.println(solution.change(5, new int[] {1, 2, 5})); // 4
  }
}
