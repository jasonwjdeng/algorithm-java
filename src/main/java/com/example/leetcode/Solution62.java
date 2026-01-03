package com.example.leetcode;

// 62. 不同路径
// https://leetcode.cn/problems/unique-paths/
public class Solution62 {
  public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int i = 0; i < n; i++) dp[0][i] = 1;
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution62 solution = new Solution62();
    System.out.println(solution.uniquePaths(3, 7)); // 28
    System.out.println(solution.uniquePaths(3, 2)); // 3
  }
}
