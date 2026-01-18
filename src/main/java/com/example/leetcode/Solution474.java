package com.example.leetcode;

// 474. 一和零
// https://leetcode.cn/problems/ones-and-zeroes/
public class Solution474 {
  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String str : strs) {
      int zero = 0;
      int one = 0;
      for (char c : str.toCharArray()) {
        if (c == '0') zero++;
        else one++;
      }
      for (int j = m; j >= zero; j--) {
        for (int k = n; k >= one; k--) {
          dp[j][k] = Math.max(dp[j][k], dp[j - zero][k - one] + 1);
        }
      }
    }
    return dp[m][n];
  }

  public int findMaxForm3d(String[] strs, int m, int n) {
    int[][][] dp = new int[strs.length][m + 1][n + 1];
    int zero = 0;
    int one = 0;
    for (char c : strs[0].toCharArray()) {
      if (c == '0') zero++;
      else one++;
    }
    for (int j = m; j >= zero; j--) {
      for (int k = n; k >= one; k--) {
        dp[0][j][k] = 1;
      }
    }
    for (int i = 1; i < strs.length; i++) {
      zero = 0;
      one = 0;
      for (char c : strs[i].toCharArray()) {
        if (c == '0') zero++;
        else one++;
      }
      for (int j = m; j >= 0; j--) {
        for (int k = n; k >= 0; k--) {
          if (j >= zero && k >= one)
            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
          else dp[i][j][k] = dp[i - 1][j][k];
        }
      }
    }
    return dp[strs.length - 1][m][n];
  }

  public static void main(String[] args) {
    Solution474 solution = new Solution474();
    System.out.println(
        solution.findMaxForm(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3)); // 4
    System.out.println(solution.findMaxForm(new String[] {"10", "0", "1"}, 1, 1)); // 2
    System.out.println(
        solution.findMaxForm3d(new String[] {"10", "0001", "111001", "1", "0"}, 5, 3)); // 4
    System.out.println(solution.findMaxForm3d(new String[] {"10", "0", "1"}, 1, 1)); // 2
  }
}
