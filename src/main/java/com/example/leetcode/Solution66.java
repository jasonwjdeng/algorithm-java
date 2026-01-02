package com.example.leetcode;

import java.util.Arrays;

// 66. 加一
// https://leetcode.cn/problems/plus-one
public class Solution66 {
  public int[] plusOne(int[] digits) {
    int i = digits.length;
    while (--i >= 0) {
      digits[i] += 1;
      if (digits[i] == 10) digits[i] = 0;
      else return digits;
    }
    digits = new int[digits.length + 1];
    digits[0] = 1;
    return digits;
  }

  public static void main(String[] args) {
    Solution66 solution = new Solution66();
    System.out.println(Arrays.toString(solution.plusOne(new int[] {1, 2, 3})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {4, 3, 2, 1})));
    System.out.println(Arrays.toString(solution.plusOne(new int[] {9})));
  }
}
