package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/*
找到字符串中所有字母异位词（LeetCode-438 中等）
https://leetcode.cn/problems/find-all-anagrams-in-a-string/
*/
public class Solution438 {
  public List<Integer> findAnagrams(String s, String p) {
    // 构建所需条件
    Map<Character, Integer> need = new HashMap<>();
    for (char c : p.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }
    // 构建窗口数据容器
    Map<Character, Integer> window = new HashMap<>();
    // 定义窗口的双指针
    int left = 0, right = 0;
    int valid = 0;
    List<Integer> result = new ArrayList<>();
    // 当右指针到达字符串末尾就退出循环
    while (right < s.length()) {
      char c = s.charAt(right++);
      if (need.containsKey(c)) {
        // 符合条件就放进window容器并计数
        window.put(c, window.getOrDefault(c, 0) + 1);
        // 如果达到所需条件就将valid计数加1
        if (Objects.equals(need.get(c), window.get(c))) valid++;
      }
      System.out.printf("window: [%d, %d), substring:%s\n", left, right, s.substring(left, right));
      // 当窗口的长度等于目标子串的长度
      // （这里不可能会有大于的情况，但保险起见还是用了大于等于）
      while (right - left >= p.length()) {
        // 当所有字符的valid计数都达到所需条件，记录子串起始位置
        if (valid == need.size()) {
          result.add(left);
        }
        // 移动左指针使得窗口整体右移1个位置
        char d = s.charAt(left++);
        if (need.containsKey(d)) {
          // 符合条件就将window容器里的计数减1
          // 如果达不到所需条件就将valid计数减1（这时会促使跳出本循环，右指针将继续移动）
          if (Objects.equals(need.get(d), window.get(d))) valid--;
          window.put(d, window.getOrDefault(d, 0) - 1);
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution438 solution = new Solution438();
    System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // [0,6]
  }
}
