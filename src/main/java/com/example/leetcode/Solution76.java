package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution76 {
  public String minWindow(String s, String t) {

    // 构建所需条件
    Map<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    // 构建窗口数据容器
    Map<Character, Integer> window = new HashMap<>();

    // 定义窗口的双指针
    int left = 0, right = 0;
    int valid = 0;
    int start = 0, len = Integer.MAX_VALUE;

    // 当右指针到达字符串末尾就退出循环
    while (right < s.length()) {
      // 检查右指针指向的字符是否符合条件
      char c = s.charAt(right++);
      if (need.containsKey(c)) {
        // 符合条件就放进window容器并计数
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 如果达到所需条件就将valid计数加1
        if (Objects.equals(window.get(c), need.get(c))) valid++;
      }

      // 当所有字符的valid计数都达到所需条件
      while (valid == need.size()) {
        // 每次循环都记录最小窗口的起始位置和长度
        if (right - left < len) {
          start = left;
          len = right - left;
        }
        // 移动左指针缩小窗口
        char d = s.charAt(left++);
        // 当左指针指向的元素符合条件
        if (need.containsKey(d)) {
          // 符合条件就将window容器里的计数减1
          // 如果达不到所需条件就将valid计数减1（这时会促使跳出本循环，右指针将继续移动）
          if (Objects.equals(window.get(d), need.get(d))) valid--;
          window.put(d, window.getOrDefault(d, 0) - 1);
        }
      }
    }

    // 输出符合条件的子串
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
  }

  public static void main(String[] args) {
    Solution76 solution = new Solution76();
    System.out.println(solution.minWindow("a", "aa"));
    System.out.println(solution.minWindow("aa", "aa"));
  }
}
