package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 78.子集
// https://leetcode.cn/problems/subsets
public class Solution78 {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    backtracking(nums, 0, result, choices);
    return result;
  }

  private void backtracking(
      int[] nums, int index, List<List<Integer>> result, List<Integer> choices) {
    result.add(new ArrayList<>(choices));
//    if (index == nums.length) {
//      return;
//    }
    for (int i = index; i < nums.length; i++) {
      choices.add(nums[i]);
      backtracking(nums, i + 1, result, choices);
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution78 solution = new Solution78();
    System.out.println(solution.subsets(new int[] {1, 2, 3}));
    System.out.println(solution.subsets(new int[] {0}));
  }
}
