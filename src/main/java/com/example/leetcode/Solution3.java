package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
无重复字符的最长子串（LeetCode-3 中等）
https://leetcode.cn/problems/longest-substring-without-repeating-characters/
*/
public class Solution3 {
  public int lengthOfLongestSubstring(String s) {
    // 定义窗口数据集合
    Map<Character, Integer> window = new HashMap<>();
    // 初始化左右双指针
    int left = 0, right = 0;
    int len = 0;
    // 当右指针到达字符串末尾就退出循环
    while (right < s.length()) {
      // 把右指针指向的字符加到window并计数
      char c = s.charAt(right++);
      window.put(c, window.getOrDefault(c, 0) + 1);
      System.out.printf("window: [%d, %d), substring:%s\n", left, right, s.substring(left, right));
      // 当该字符的计数大于1（即重复字符），就缩小窗口
      while (window.get(c) > 1) {
        // 把左指针指向的字符移出window
        char d = s.charAt(left++);
        window.put(d, window.get(d) - 1);
      }
      // 记录每次循环后的最大的窗口长度
      len = Math.max(len, right - left);
      System.out.println("window=" + window + ",len=" + len + ",left=" + left + ",right=" + right);
    }
    return len;
  }

  public static void main(String[] args) {
    Solution3 solution = new Solution3();
    //    System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
    //    System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // 1
    System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // 3
    //    System.out.println(solution.lengthOfLongestSubstring("pww")); // 2
    //    System.out.println(solution.lengthOfLongestSubstring("dvdf")); // 3
  }
}
