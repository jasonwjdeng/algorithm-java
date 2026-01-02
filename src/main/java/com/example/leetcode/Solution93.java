package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 93. 复原 IP 地址
// https://leetcode.cn/problems/restore-ip-addresses/
public class Solution93 {
  public List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();
    List<String> choices = new ArrayList<>();
    backtracking(s, 0, result, choices);
    return result;
  }

  private void backtracking(String s, int index, List<String> result, List<String> choices) {
    if (index == s.length()) {
      if (choices.size() == 4) {
        result.add(String.join(".", choices));
      }
      return;
    }
    for (int i = index; i < s.length() && i - index < 3; i++) {
      String substring = s.substring(index, i + 1);
      if (isValidIpSegment(substring)) {
        choices.add(substring);
        backtracking(s, i + 1, result, choices);
        choices.removeLast();
      }
    }
  }

  private boolean isValidIpSegment(String s) {
    return s.equals("0") || !s.startsWith("0") && Integer.parseInt(s) < 256;
  }

  public static void main(String[] args) {
    Solution93 solution = new Solution93();
    System.out.println(solution.restoreIpAddresses("25525511135"));
    System.out.println(solution.restoreIpAddresses("0000"));
    System.out.println(solution.restoreIpAddresses("101023"));
  }
}
