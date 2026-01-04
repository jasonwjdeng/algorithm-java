package com.example.leetcode;

// 63. 不同路径 II
// https://leetcode.cn/problems/unique-paths-ii/
public class Solution63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    // 定义dp数组
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m][n];

    // 初始化dp数组
    // 第1列统统都是1，因为可以沿着直线向下走，不需要拐弯
    // 但是遇到障碍物就停下来
    for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) dp[i][0] = 1;
    // 第1行统统都是1，因为可以沿着直线向右走，不需要拐弯
    // 但是遇到障碍物就停下来
    for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) dp[0][i] = 1;

    // 从点(1,1)开始遍历
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // 所有需要拐弯到达的位置(即除第1行和第1列的所有位置)，如果没有障碍物，计算从左边或上边两个位置过来的路径总和
        if (obstacleGrid[i][j] == 0) dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }

    // 输出终点的路径和
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution63 solution = new Solution63();
    System.out.println(
        solution.uniquePathsWithObstacles(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})); // 2
    System.out.println(solution.uniquePathsWithObstacles(new int[][] {{0, 1}, {0, 0}})); // 1
  }
}
