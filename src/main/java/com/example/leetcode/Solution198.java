package com.example.leetcode;

// 198. 打家劫舍
// https://leetcode.cn/problems/house-robber/
// 提示：
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
public class Solution198 {
  public int rob(int[] nums) {
    // 当nums.length==1时
    if (nums.length < 2) return nums[0];
    // dp[i]表示打劫第0-i家获得的最高金额
    int[] dp = new int[nums.length];
    // 打劫第0家
    dp[0] = nums[0];
    // 打劫第0或者1家，取最高金额者
    dp[1] = Math.max(nums[0], nums[1]);
    // 从第2家开始遍历
    for (int i = 2; i < nums.length; i++) {
      // 打劫第i-2和i家，或者第i-1家，取最高金额者
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[nums.length - 1];
  }
}
