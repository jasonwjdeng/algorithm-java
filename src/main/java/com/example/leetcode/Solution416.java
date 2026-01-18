package com.example.leetcode;

import java.util.Arrays;

// 416. 分割等和子集
// https://leetcode.cn/problems/partition-equal-subset-sum/
public class Solution416 {
  public boolean canPartition(int[] nums) {
    // 算总和
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    // 如果总和不能平均分，则没有符合题意的解
    if (sum % 2 > 0) return false;
    // 计算目标和
    int n = sum / 2;
    int[] dp = new int[n + 1];
    // 用0-1背包的解法
    // 尝试把数组中的元素放进背包，如果刚好放满，即为最终解
    for (int num : nums) {
      for (int j = n; j >= num; j--) {
        dp[j] = Math.max(dp[j], dp[j - num] + num);
      }
      // 刚好放满，即符合题意
      if (dp[n] == n) return true;
    }
    // 判断是否刚好放满
    return dp[n] == n;
  }

  public boolean canPartition2D(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 > 0) return false;
    int n = sum / 2;
    int len = nums.length;
    int[][] dp = new int[len][n + 1];
    for (int j = nums[0]; j <= n; j++) {
      dp[0][j] = nums[0];
    }
    for (int i = 1; i < len; i++) {
      for (int j = 0; j <= n; j++) {
        if (j < nums[i]) dp[i][j] = dp[i - 1][j];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - nums[i]] + nums[i]);
      }
    }
    return dp[len - 1][n] == n;
  }

  public static void main(String[] args) {
    Solution416 solution = new Solution416();
    System.out.println(solution.canPartition(new int[] {1, 5, 11, 5})); // true
    System.out.println(solution.canPartition(new int[] {1, 2, 3, 5})); // false
    System.out.println(solution.canPartition2D(new int[] {1, 5, 11, 5})); // true
    System.out.println(solution.canPartition2D(new int[] {1, 2, 3, 5})); // false
  }
}
