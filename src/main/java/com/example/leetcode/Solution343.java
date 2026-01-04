package com.example.leetcode;

// 343. 整数拆分
// https://leetcode.cn/problems/integer-break/
public class Solution343 {
  public int integerBreak(int n) {
    // dp[i] 为正整数 i 拆分后的结果的最大乘积
    int[] dp = new int[n + 1];
    // 初始化dp数组，dp[0]和dp[1]无意义，不会用到
    dp[2] = 1;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        // j * (i - j) 是单纯的把整数 i 拆分为两个数 也就是 i,i-j ，再相乘
        // 而j * dp[i - j]是将 i 拆分成两个以及两个以上的个数,再相乘。
        dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    Solution343 solution = new Solution343();
    System.out.println(solution.integerBreak(2)); // 1
    System.out.println(solution.integerBreak(10)); // 36
  }
}
