package com.example.leetcode;

// 647. 回文子串
// https://leetcode.cn/problems/palindromic-substrings/
public class Solution647 {
  public int countSubstrings(String s) {
    int len = s.length();
    // 布尔类型的dp[i][j]：表示区间范围[i,j] （注意是左闭右闭）的子串是否是回文子串，如果是dp[i][j]为true，否则为false。
    boolean[][] dp = new boolean[len][len];
    int count = 0;
    for (int i = len - 1; i >= 0; i--) {
      for (int j = i; j < len; j++) {
        // 下标i和j所在的字符相同
        if (s.charAt(i) == s.charAt(j)) {
          // i和j相同或者相邻
          if (j - i <= 1) {
            dp[i][j] = true;
            count++;

          } else
          // i和j相隔1个字符以上，就看相邻两个字符是否相同
          if (dp[i + 1][j - 1]) {
            dp[i][j] = true;
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution647 solution = new Solution647();
    System.out.println(solution.countSubstrings("abc")); // 3
    System.out.println(solution.countSubstrings("aaa")); // 6
  }
}
