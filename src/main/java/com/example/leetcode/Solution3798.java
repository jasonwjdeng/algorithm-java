package com.example.leetcode;

// 3798.最大的偶数
// https://leetcode.cn/problems/largest-even-number/
public class Solution3798 {
  public String largestEven(String s) {
    int index = s.lastIndexOf("2");
    return index < 0 ? "" : s.substring(0, index + 1);
  }

  public static void main(String[] args) {
    Solution3798 solution = new Solution3798();
    System.out.println(solution.largestEven("1112")); // "1112"
    System.out.println(solution.largestEven("221")); // "22"
    System.out.println(solution.largestEven("1")); // ""
  }
}
