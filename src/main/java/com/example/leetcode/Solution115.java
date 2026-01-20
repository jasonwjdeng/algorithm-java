package com.example.leetcode;

// 115. 不同的子序列
// https://leetcode.cn/problems/distinct-subsequences/
public class Solution115 {
  public int numDistinct(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int[] dp = new int[tLen + 1];
    dp[0] = 1;
    for (int i = 0; i < sLen; i++) {
      char c = s.charAt(i);
      for (int j = tLen; j > 0; j--) {
        if (c == t.charAt(j - 1)) dp[j] += dp[j - 1];
      }
    }
    return dp[tLen];
  }

  public int numDistinct2(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int[][] dp = new int[sLen + 1][tLen + 1];
    for (int i = 0; i <= sLen; i++) {
      dp[i][0] = 1;
    }
    for (int i = 1; i <= sLen; i++) {
      char c = s.charAt(i - 1);
      for (int j = 1; j <= tLen; j++) {
        if (c == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        else dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[sLen][tLen];
  }
}
