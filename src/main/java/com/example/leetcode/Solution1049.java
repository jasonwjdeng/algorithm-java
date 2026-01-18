package com.example.leetcode;

import java.util.Arrays;

// 1049. 最后一块石头的重量 II
// https://leetcode.cn/problems/last-stone-weight-ii/
public class Solution1049 {
  public int lastStoneWeightII(int[] stones) {
    int sum = 0;
    for (int weight : stones) {
      sum += weight;
    }
    int n = sum / 2;
    int[] dp = new int[n + 1];
    for (int weight : stones) {
      for (int i = n; i >= weight; i--) {
        dp[i] = Math.max(dp[i], dp[i - weight] + weight);
      }
    }
//    System.out.println(Arrays.toString(dp));
    return sum - 2 * dp[n];
  }

  public static void main(String[] args) {
    Solution1049 solution = new Solution1049();
    System.out.println(solution.lastStoneWeightII(new int[] {2, 7, 4, 1, 8, 1})); // 1
    System.out.println(solution.lastStoneWeightII(new int[] {31, 26, 33, 21, 40})); // 5
  }
}
