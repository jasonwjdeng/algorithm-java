package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 491. 非递减子序列
// https://leetcode.cn/problems/non-decreasing-subsequences/
public class Solution491 {
  public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    backtracking(nums, 0, result, choices);
    return result;
  }

  private void backtracking(
      int[] nums, int index, List<List<Integer>> result, List<Integer> choices) {
    if (choices.size() > 1) {
      result.add(new ArrayList<>(choices));
//      return;
    }
    Set<Integer> set = new HashSet<>();
    for (int i = index; i < nums.length; i++) {
      if (!choices.isEmpty() && nums[i] < choices.getLast() || set.contains(nums[i])) continue;
      //        System.out.printf("i=%d,choices=%s%n", i, choices);
      choices.add(nums[i]);
      set.add(nums[i]);
      backtracking(nums, i + 1, result, choices);
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution491 solution = new Solution491();
    System.out.println(solution.findSubsequences(new int[] {4, 6, 7, 7}));
    System.out.println(solution.findSubsequences(new int[] {4, 4, 3, 2, 1}));
  }
}
