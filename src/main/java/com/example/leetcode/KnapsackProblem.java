package com.example.leetcode;

import java.util.Arrays;

// 背包问题分类：
// 0/1 背包 0/1 knapsack
// 完全背包 unbounded knapsack
// 多重背包 bounded knapsack
public class KnapsackProblem {
  public static void main(String[] args) {
    zeroOneKnapsack1Dim();
    zeroOneKnapsack2Dim();
    unboundedKnapsack();
  }

  private static void zeroOneKnapsack1Dim() {
    int noOfItems = 3, knapsackCapacity = 4;
    int[] weight = new int[] {2, 1, 3};
    int[] value = new int[] {4, 2, 3};
    // 初始化dp数组
    // dp[j]表示容量为j的背包能容纳物品的最大价值
    int[] dp = new int[knapsackCapacity + 1];
    // 遍历物品
    for (int i = 0; i < weight.length; i++) {
      // 遍历背包，容量从大到小倒序，避免物品被放入多次
      for (int j = knapsackCapacity; j > 0; j--) {
        // 跳过超过容量的物品
        if (j < weight[i]) continue;
        // j容量的背包价值=max(不放i物品的价值，放i物品的价值)
        dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
      }
      System.out.println(Arrays.toString(dp));
    }
    System.out.println(dp[knapsackCapacity]);
  }

  private static void zeroOneKnapsack2Dim() {
    int noOfItems = 3, knapsackCapacity = 4;
    int[] weight = new int[] {3, 2, 1};
    int[] value = new int[] {3, 4, 2};
    // 初始化dp数组
    // dp[i][j]表示容量为j的背包任意选取放入第0到第i个物品的最大价值
    int[][] dp = new int[noOfItems][knapsackCapacity + 1];
    // 先尝试放入第0个物品
    for (int j = weight[0]; j <= knapsackCapacity; j++) {
      dp[0][j] = value[0];
    }
    // 遍历物品（先遍历背包再遍历物品都可以）
    for (int i = 1; i < weight.length; i++) {
      // 遍历背包，无所谓正序倒序
      for (int j = 0; j <= knapsackCapacity; j++) {
        // 当容量为j的背包无法放进i物品，其价值等于任意选取放入第0到第i-1物品时的价值
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        // dp[i][j]=max(任意选取放入第0到第i-1物品时的价值,选取第i个物品时的价值)
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
      }
      System.out.println(Arrays.deepToString(dp));
    }
    System.out.println(dp[noOfItems - 1][knapsackCapacity]);
  }

  private static void unboundedKnapsack() {
    int noOfItems = 3, knapsackCapacity = 4;
    int[] weight = new int[] {1, 3, 4};
    int[] value = new int[] {15, 20, 30};
    // 初始化dp数组
    // dp[i][j]表示容量为j的背包任意选取放入第0到第i个物品的最大价值
    int[][] dp = new int[noOfItems][knapsackCapacity + 1];
    // 当 dp[0][j] 如果能放下weight[0]的话，就一直装，每一种物品有无限个
    for (int j = weight[0]; j <= knapsackCapacity; j++) {
      dp[0][j] = dp[0][j - weight[0]] + value[0];
    }
    // 遍历物品（先遍历背包再遍历物品都可以）
    for (int i = 1; i < weight.length; i++) {
      // 遍历背包，无所谓正序倒序
      for (int j = 0; j <= knapsackCapacity; j++) {
        // 当容量为j的背包无法放进i物品，其价值等于任意选取放入第0到第i-1物品时的价值
        if (j < weight[i]) dp[i][j] = dp[i - 1][j];
        // dp[i][j]=max(任意选取放入第0到第i-1物品时的价值,选取第i个物品时的价值)
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weight[i]] + value[i]);
      }
      System.out.println(Arrays.deepToString(dp));
    }
    System.out.println(dp[noOfItems - 1][knapsackCapacity]);
  }
}
