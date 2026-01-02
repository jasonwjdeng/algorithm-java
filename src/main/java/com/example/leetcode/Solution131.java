package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 131.分割回文串
// https://leetcode.cn/problems/palindrome-partitioning
public class Solution131 {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> choices = new ArrayList<>();
    backtracking(s, 0, result, choices);
    return result;
  }

  private void backtracking(String s, int index, List<List<String>> result, List<String> choices) {
    if (index == s.length()) {
      result.add(new ArrayList<>(choices));
      return;
    }
    for (int i = index; i < s.length(); i++) {
      if (isPalindrome(s, index, i)) {
        choices.add(s.substring(index, i + 1));
        backtracking(s, i + 1, result, choices);
        choices.removeLast();
      }
    }
  }

  private boolean isPalindrome(String s, int start, int end) {
    for (int i = start, j = end; i < j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution131 solution = new Solution131();
    System.out.println(solution.partition("aab"));
    System.out.println(solution.partition("a"));
  }
}
