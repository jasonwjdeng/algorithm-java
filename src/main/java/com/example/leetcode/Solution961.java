package com.example.leetcode;

import java.util.HashSet;
import java.util.Set;

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
