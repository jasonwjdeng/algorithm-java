package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 322.零钱兑换
// https://leetcode.cn/problems/coin-change/
public class Solution322 {

  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    //初始化dp数组为最大值
    Arrays.fill(dp, amount + 1);
    //当金额为0时需要的硬币数目为0
    dp[0] = 0;
    for (int coin : coins) {
      //正序遍历：完全背包每个硬币可以选择多次
      for (int j = coin; j <= amount; j++) {
        //只有dp[j-coins[i]]不是初始最大值时，该位才有选择的必要
        if (dp[j - coin] != amount + 1) {
          //选择硬币数目最小的情况
          dp[j] = Math.min(dp[j], dp[j - coin] + 1);
        }
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
//  public int coinChange(int[] coins, int amount) {
//    int[] dp = new int[amount + 1];
//    Arrays.fill(dp, amount + 1);
//    dp[0] = 0;
//    for (int i = 0; i < dp.length; i++) {
//      for (int coin : coins) {
//        if (i < coin) continue;
//        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//      }
//    }
//    return (dp[amount] == amount + 1) ? -1 : dp[amount];
//  }

//  private Map<Integer, Integer> memo;
//
//  public int coinChange(int[] coins, int amount) {
//    memo = new HashMap<>();
//    return dp(coins, amount);
//  }
//
//  private int dp(int[] coins, int amount) {
//    System.out.printf("amount=%d,memo=%s%n", amount, memo);
//    if (memo.containsKey(amount)) return memo.get(amount);
//    if (amount == 0) return 0;
//    if (amount < 0) return -1;
//    int result = Integer.MAX_VALUE;
//    for (int coin : coins) {
//      int subProblem = dp(coins, amount - coin);
//      if (subProblem < 0) continue;
//      result = Math.min(result, subProblem + 1);
//    }
//    if (result == Integer.MAX_VALUE) result = -1;
//    memo.put(amount, result);
//    return result;
//  }

  public static void main(String[] args) {
    Solution322 solution = new Solution322();
    System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11)); // 3
    System.out.println(solution.coinChange(new int[] {2}, 3)); // -1
    System.out.println(solution.coinChange(new int[] {2, 5, 10, 1}, 27)); // 4
    System.out.println(solution.coinChange(new int[] {186, 419, 83, 408}, 6249)); // 20
  }
}
