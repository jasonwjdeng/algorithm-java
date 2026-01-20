package com.example.leetcode;

// 1143. 最长公共子序列
// https://leetcode.cn/problems/longest-common-subsequence/
public class Solution1143 {
  public int longestCommonSubsequence2(String text1, String text2) {
    int len1 = text1.length();
    int len2 = text2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 1; i <= len1; i++) {
      char c = text1.charAt(i - 1);
      for (int j = 1; j <= len2; j++) {
        if (c == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[len1][len2];
  }
}
