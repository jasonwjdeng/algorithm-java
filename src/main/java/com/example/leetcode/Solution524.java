package com.example.leetcode;

import java.util.List;

public class Solution524 {
  public String findLongestWord(String s, List<String> dictionary) {
    String result = "";
    for (String word : dictionary) {
      int i = 0, j = 0;
      // 遍历s和word，直到最少其中一个遍历完为止
      while (i < s.length() && j < word.length()) {
        if (s.charAt(i) == word.charAt(j)) {
          j++;
        }
        i++;
      }
      // 找到word
      if (j == word.length()) {
        // 如果word的长度比result大
        if (word.length() > result.length()
            // 或者相同长度但是word的字母序比result小
            || (word.length() == result.length() && word.compareTo(result) < 0)) {
          // 那么就把word当成result
          result = word;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution524 solution = new Solution524();
    System.out.println(
        solution.findLongestWord("abpcplea", List.of("ale", "apple", "monkey", "plea")));
    System.out.println(solution.findLongestWord("abpcplea", List.of("a", "b", "c", "d")));
  }
}
