package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 90.子集II
// https://leetcode.cn/problems/subsets-ii
public class Solution90 {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    Arrays.sort(nums);
    backtracking(nums, 0, result, choices);
    return result;
  }

  private void backtracking(
      int[] nums, int index, List<List<Integer>> result, List<Integer> choices) {
    result.add(new ArrayList<>(choices));
    if (index == nums.length) {
      return;
    }
    for (int i = index; i < nums.length; i++) {
      if (i > index && nums[i] == nums[i - 1]) continue;
      choices.add(nums[i]);
      backtracking(nums, i + 1, result, choices);
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution90 solution = new Solution90();
    System.out.println(solution.subsetsWithDup(new int[] {1, 2, 2}));
    System.out.println(solution.subsetsWithDup(new int[] {0}));
    System.out.println(solution.subsetsWithDup(new int[] {4, 4, 4, 1, 4}));
  }
}
