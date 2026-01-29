package com.example.leetcode;

import java.util.Arrays;

// 377. 组合总和 Ⅳ
// https://leetcode.cn/problems/combination-sum-iv/
public class Solution377 {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int j = 0; j <= target; j++) {
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
