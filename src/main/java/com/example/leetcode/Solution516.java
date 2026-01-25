package com.example.leetcode;

// 516.最长回文子序列
// https://leetcode.cn/problems/longest-palindromic-subsequence/
public class Solution516 {
  public int longestPalindromeSubseq(String s) {
    int len = s.length();
    // dp[i][j]：字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]。
    int[][] dp = new int[len][len];
    // 从递归公式中，可以看出，dp[i][j] 依赖于 dp[i + 1][j - 1] ，dp[i + 1][j] 和 dp[i][j -1]，
    // 所以遍历i的时候一定要从下到上遍历，这样才能保证下一行的数据是经过计算的。
    // j的话，可以正常从左向右遍历。
    for (int i = len - 1; i >= 0; i--) {
      dp[i][i] = 1;
      char c = s.charAt(i);
      for (int j = i + 1; j < len; j++) {
        // 如果s[i]与s[j]相同，那么dp[i][j] = dp[i + 1][j - 1] + 2;
        if (c == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
        // 如果s[i]与s[j]不相同，说明s[i]和s[j]的同时加入 并不能增加[i,j]区间回文子序列的长度，那么分别加入s[i]、s[j]看看哪一个可以组成最长的回文子序列。
        // 加入s[j]的回文子序列长度为dp[i + 1][j]。
        // 加入s[i]的回文子序列长度为dp[i][j - 1]。
        // 那么dp[i][j]一定是取最大的，即：dp[i][j] = max(dp[i + 1][j], dp[i][j - 1]);
        else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
      }
    }
    return dp[0][len - 1];
  }
}
