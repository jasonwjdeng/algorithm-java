package com.example.leetcode;

public class Solution345 {
  public String reverseVowels(String s) {
    char[] chars = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      // 从左往右找元音字母，直到遍历完或者找到为止
      while (left < s.length() && !isVowel(chars[left])) {
        left++;
      }
      // 从右往左找元音字母，直到遍历完或者找到为止
      while (right > 0 && !isVowel(chars[right])) {
        right--;
      }
      // 如果找到就交换两个字母的位置
      // 继续往左右两边移动找下一对
      if (left < right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }
    return new String(chars);
  }

  private static boolean isVowel(char c) {
    return "aeiouAEIOU".indexOf(c) >= 0;
  }

  public static void main(String[] args) {
    Solution345 solution = new Solution345();
    System.out.println(solution.reverseVowels("IceCreAm"));
    System.out.println(solution.reverseVowels("leetcode"));
  }
}
