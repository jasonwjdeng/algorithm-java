package com.example.leetcode;

public class Solution680 {
  public boolean validPalindrome(String s) {
    // 左右双指针
    int left = 0, right = s.length() - 1;
    // 从左右两边往中间遍历字符串每个元素
    while (left < right) {
      // 如果左右两个字符不同就分别判断
      if (s.charAt(left) != s.charAt(right)) {
        // 贪心算法：跳过左边一个字符看是不是回文，或者跳过右边一个字符看是不是回文
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
      }
      left++;
      right--;
    }
    return true;
  }

  private boolean isPalindrome(String s, int left, int right) {
    // 从左右两边往中间遍历字符串每个元素
    while (left < right) {
      // 如果左右两个字符不同就不是回文串
      if (s.charAt(left) != s.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    Solution680 solution = new Solution680();
    System.out.println(
        solution.validPalindrome(
            "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }
}
