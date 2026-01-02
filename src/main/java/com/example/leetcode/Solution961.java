package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

// 961. 在长度 2N 的数组中找出重复 N 次的元素
// https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
public class Solution961 {
  public int repeatedNTimes(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) return num;
      //      set.add(num);
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution961 solution = new Solution961();
    System.out.println(solution.repeatedNTimes(new int[] {1, 2, 3, 3})); // 3
    System.out.println(solution.repeatedNTimes(new int[] {2, 1, 2, 5, 3, 2})); // 2
    System.out.println(solution.repeatedNTimes(new int[] {5, 1, 5, 2, 5, 3, 5, 4})); // 5
  }
}
