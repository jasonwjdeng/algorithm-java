package com.example.leetcode;

// 583. 两个字符串的删除操作
// https://leetcode.cn/problems/delete-operation-for-two-strings/
public class Solution583 {
  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    // dp[i][j]：以i-1为结尾的字符串word1，和以j-1位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数。
    int[][] dp = new int[len1 + 1][len2 + 1];
    // dp[i][0]：word2为空字符串，以i-1为结尾的字符串word1要删除多少个元素，才能和word2相同呢，很明显dp[i][0] = i。
    // dp[0][j]的话同理
    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= len1; i++) {
      char c = word1.charAt(i - 1);
      for (int j = 1; j <= len2; j++) {
        // 当word1[i - 1] 与 word2[j - 1]相同的时候，dp[i][j] = dp[i - 1][j - 1];
        if (c == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        else
          // 当word1[i - 1] 与 word2[j - 1]不相同的时候，有三种情况：
          // 情况一：删word1[i - 1]，最少操作次数为dp[i - 1][j] + 1
          // 情况二：删word2[j - 1]，最少操作次数为dp[i][j - 1] + 1
          // 情况三：同时删word1[i - 1]和word2[j - 1]，操作的最少次数为dp[i - 1][j - 1] + 2
          // 那最后当然是取最小值
          dp[i][j] = Math.min(dp[i - 1][j - 1] + 2, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
      }
    }
    return dp[len1][len2];
  }

  // See Solution1143，最长公共子序列
  public int minDistance2(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 1; i <= len1; i++) {
      char c = word1.charAt(i - 1);
      for (int j = 1; j <= len2; j++) {
        if (c == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    // 两个字符串长度和-两倍最长公共子序列
    return len1 + len2 - 2 * dp[len1][len2];
  }
}
