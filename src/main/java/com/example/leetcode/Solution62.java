package com.example.leetcode;

// 62. 不同路径
// https://leetcode.cn/problems/unique-paths/
public class Solution62 {
  public int uniquePaths(int m, int n) {
    // 定义dp数组
    int[][] dp = new int[m][n];

    // 初始化dp数组
    // 第1列统统都是1，因为可以沿着直线向下走，不需要拐弯
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    // 第1行统统都是1，因为可以沿着直线向右走，不需要拐弯
    for (int i = 0; i < n; i++) dp[0][i] = 1;

    // 从点(1,1)开始遍历
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        // 所有需要拐弯到达的位置(即除第1行和第1列的所有位置)，计算从左边或上边两个位置过来的路径总和
        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
      }
    }

    // 输出终点的路径和
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    Solution62 solution = new Solution62();
    System.out.println(solution.uniquePaths(3, 7)); // 28
    System.out.println(solution.uniquePaths(3, 2)); // 3
  }
}
