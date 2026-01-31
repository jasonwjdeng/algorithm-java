package com.example.leetcode;

// 494. 目标和
// https://leetcode.cn/problems/target-sum
public class Solution494 {
  public int findTargetSumWays(int[] nums, int target) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if ((target + sum) % 2 > 0) return 0;
    if (Math.abs(target) > sum) return 0;
    int n = (target + sum) / 2;
    // 填满j（包括j）这么大容积的包，有dp[j]种方法
    int[] dp = new int[n + 1];
    // 装满背包为0的方法有一种，放0件物品
    dp[0] = 1;
    // 正序遍历物品
    for (int num : nums) {
      // 再倒序遍历背包
      for (int i = n; i >= num; i--) {
        dp[i] += dp[i - num];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Solution494 solution = new Solution494();
    System.out.println(solution.findTargetSumWays(new int[] {1, 1, 1, 1, 1}, 3)); // 5
    System.out.println(solution.findTargetSumWays(new int[] {1}, 1)); // 1
  }
}
