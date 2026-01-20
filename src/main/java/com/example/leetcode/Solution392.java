package com.example.leetcode;

// 392. 判断子序列
// https://leetcode.cn/problems/is-subsequence/
public class Solution392 {

  // 双指针解法
  public boolean isSubsequence(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int i = 0, j = 0;
    while (i < sLen && j < tLen) {
      if (s.charAt(i) == t.charAt(j)) i++;
      j++;
    }
    return i == sLen;
  }

  // 动态规划最终解法
  public boolean isSubsequenceDP(String s, String t) {
    int sLen = s.length();
    boolean[] dp = new boolean[sLen + 1];
    dp[0] = true;
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      for (int j = s.length(); j > 0; j--) {
        if (c == s.charAt(j - 1)) dp[j] = dp[j - 1];
      }
    }
    return dp[sLen];
  }

  // 压缩dp数组
  public boolean isSubsequence2(String s, String t) {
    int sLen = s.length();
    int[] dp = new int[sLen + 1];
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      for (int j = s.length(); j > 0; j--) {
        if (c == s.charAt(j - 1)) dp[j] = dp[j - 1] + 1;
      }
    }
    return dp[sLen] == sLen;
  }

  // 改变遍历顺序
  public boolean isSubsequence3(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int[][] dp = new int[tLen + 1][sLen + 1];
    for (int i = 1; i <= t.length(); i++) {
      char c = t.charAt(i - 1);
      for (int j = 1; j <= s.length(); j++) {
        if (c == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = dp[i - 1][j];
      }
    }
    return dp[tLen][sLen] == sLen;
  }

  // 初始版本
  public boolean isSubsequence4(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    int[][] dp = new int[sLen + 1][tLen + 1];
    for (int i = 1; i <= s.length(); i++) {
      char c = s.charAt(i - 1);
      for (int j = 1; j <= t.length(); j++) {
        if (c == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = dp[i][j - 1];
      }
    }
    return dp[sLen][tLen] == sLen;
  }
}
