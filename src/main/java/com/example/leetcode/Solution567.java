package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution567 {
  public boolean checkInclusion(String s1, String s2) {
    // 构建所需条件
    Map<Character, Integer> need = new HashMap<>();
    for (char c : s1.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    // 构建窗口数据容器
    Map<Character, Integer> window = new HashMap<>();

    // 定义窗口的双指针
    int left = 0, right = 0;
    int valid = 0;

    // 当右指针到达字符串末尾就退出循环
    while (right < s2.length()) {
      // 检查右指针指向的字符是否符合条件
      char c = s2.charAt(right++);
      if (need.containsKey(c)) {
        // 符合条件就放进window容器并计数
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 如果达到所需条件就将valid计数加1
        if (Objects.equals(need.get(c), window.get(c))) valid++;
      }
      // 当所有字符的valid计数都达到所需条件
      while (valid == need.size()) {
        // 达到所需条件时的窗口长度和s1相等，证明s2包含了s1
        if (right - left == s1.length()) {
          return true;
        }
        // 移动左指针缩小窗口
        char d = s2.charAt(left++);
        // 当左指针指向的元素符合条件
        if (need.containsKey(d)) {
          // 符合条件就将window容器里的计数减1
          // 如果达不到所需条件就将valid计数减1（这时会促使跳出本循环，右指针将继续移动）
          if (Objects.equals(need.get(d), window.get(d))) valid--;
          window.put(d, window.getOrDefault(d, 0) - 1);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Solution567 solution = new Solution567();
    System.out.println(solution.checkInclusion("ab", "eidbaooo")); // true
    System.out.println(solution.checkInclusion("ab", "eidboaoo")); // false
  }
}
