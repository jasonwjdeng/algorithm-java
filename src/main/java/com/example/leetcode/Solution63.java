package com.example.leetcode;

// 63. 不同路径 II
// https://leetcode.cn/problems/unique-paths-ii/
public class Solution63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];
    for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;

    for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) dp[0][i] = 1;

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (obstacleGrid[i][j] == 0) dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution63 solution = new Solution63();
    System.out.println(
        solution.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})); // 2
    System.out.println(solution.uniquePathsWithObstacles(new int[][] {{0, 1}, {0, 0}})); // 1
  }
}
