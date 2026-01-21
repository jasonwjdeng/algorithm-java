package com.example.leetcode;

// 1143. 最长公共子序列
// https://leetcode.cn/problems/longest-common-subsequence/
public class Solution1143 {
  public int longestCommonSubsequence2(String text1, String text2) {
    int len1 = text1.length();
    int len2 = text2.length();
    // dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
    // dp[i][0]：text1[0, i-1]和空串的最长公共子序列自然是0，所以dp[i][0] = 0;
    // 同理dp[0][j]也是0。
    int[][] dp = new int[len1 + 1][len2 + 1];
    for (int i = 1; i <= len1; i++) {
      char c = text1.charAt(i - 1);
      for (int j = 1; j <= len2; j++) {
        // 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
        if (c == text2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        // 如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i
        // - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[len1][len2];
  }
}
