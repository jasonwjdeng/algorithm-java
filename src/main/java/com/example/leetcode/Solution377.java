package com.example.leetcode;

import java.util.Arrays;

// 377. 组合总和 Ⅳ
// https://leetcode.cn/problems/combination-sum-iv/
public class Solution377 {
  public int combinationSum4(int[] nums, int target) {
    // dp[j]表示和为j的组合个数
    int[] dp = new int[target + 1];
    // 和为0的组合只有1种，就是什么都不选
    dp[0] = 1;
    // 先遍历背包
    for (int j = 0; j <= target; j++) {
      // 再遍历物品
      for (int i = 0; i < nums.length; i++) {
        if (j >= nums[i]) dp[j] += dp[j - nums[i]];
      }
    }
    //    System.out.println(Arrays.toString(dp));
    return dp[target];
  }

  public static void main(String[] args) {
    Solution377 solution = new Solution377();
    System.out.println(solution.combinationSum4(new int[] {1, 2, 3}, 4)); // 7
  }
}
