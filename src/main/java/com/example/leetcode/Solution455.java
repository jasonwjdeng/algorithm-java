package com.example.leetcode;

import java.util.Arrays;

// 455.分发饼干
// https://leetcode.cn/problems/assign-cookies/
public class Solution455 {
  public int findContentChildren(int[] g, int[] s) {
    // 对胃口和饼干排序
    Arrays.sort(g);
    Arrays.sort(s);
    int result = 0;
    int index = s.length - 1;
    // 从最大胃口的小孩开始，在饼干中选择符合胃口的最大的饼干分配给他
    for (int i = g.length - 1; i >= 0 && index >= 0; i--) {
      if (s[index] >= g[i]) {
        // 找到符合胃口的饼干就计数
        result++;
        // 同时饼干索引指向剩余最大的饼干
        index--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution455 solution = new Solution455();
    System.out.println(solution.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
    System.out.println(solution.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3}));
    System.out.println(solution.findContentChildren(new int[] {1, 2, 3}, new int[] {}));
  }
}
