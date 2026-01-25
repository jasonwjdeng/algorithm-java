package com.example.leetcode;

// 72. 编辑距离
// https://leetcode.cn/problems/edit-distance/
public class Solution72 {
  public int minDistance(String word1, String word2) {
    int len1 = word1.length();
    int len2 = word2.length();
    // dp[i][j]：以下标i-1为结尾的字符串word1，和以下标j-1为结尾的字符串word2，最近编辑距离为dp[i][j]。
    int[][] dp = new int[len1 + 1][len2 + 1];
    // dp[i][0]：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离为dp[i][0]。
    // 那么dp[i][0]就应该是i，对word1里的元素全部做删除操作，即：dp[i][0] = i;
    // 同理dp[0][j] = j;
    for (int i = 0; i <= len1; i++) {
      dp[i][0] = i;
    }
    for (int j = 0; j <= len2; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= len1; i++) {
      char c = word1.charAt(i - 1);
      for (int j = 1; j <= len2; j++) {
        // if (word1[i - 1] == word2[j - 1]) 那么说明不用任何编辑，dp[i][j] 就应该是 dp[i - 1][j - 1]，
        // 即dp[i][j] = dp[i - 1][j - 1];
        if (c == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        // if (word1[i - 1] != word2[j - 1])，此时就需要编辑了，如何编辑呢？

        // 操作一：word1删除一个元素，那么就是以下标i - 2为结尾的word1 与 j-1为结尾的word2的最近编辑距离 再加上一个操作。
        // 即 dp[i][j] = dp[i - 1][j] + 1;

        // 操作二：word2删除一个元素，那么就是以下标i - 1为结尾的word1 与 j-2为结尾的word2的最近编辑距离 再加上一个操作。
        // 即 dp[i][j] = dp[i][j - 1] + 1;

        // 操作三：替换元素，word1替换word1[i - 1]，使其与word2[j - 1]相同，此时不用增删加元素。
        // 可以回顾一下，if (word1[i - 1] == word2[j - 1])的时候我们的操作 是 dp[i][j] = dp[i - 1][j - 1] 对吧。
        // 那么只需要一次替换的操作，就可以让 word1[i - 1] 和 word2[j - 1] 相同。
        // 所以 dp[i][j] = dp[i - 1][j - 1] + 1;

        // 综上，当 if (word1[i - 1] != word2[j - 1]) 时取最小的，即：
        // dp[i][j] = min({dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]}) + 1;
        else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
      }
    }
    return dp[len1][len2];
  }
}
