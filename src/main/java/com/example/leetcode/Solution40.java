package com.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40. 组合总和 II
// https://leetcode.cn/problems/combination-sum-ii/
public class Solution40 {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    Arrays.sort(candidates);
    backtracking(candidates, target, 0, result, choices, 0);
    return result;
  }

  private void backtracking(
      int[] candidates,
      int target,
      int index,
      List<List<Integer>> result,
      List<Integer> choices,
      int sum) {
    if (sum == target) {
      result.add(new ArrayList<>(choices));
      return;
    }
    for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
      if (i > index && candidates[i] == candidates[i - 1]) continue;
      choices.add(candidates[i]);
      backtracking(candidates, target, i + 1, result, choices, sum + candidates[i]);
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution40 solution = new Solution40();
    System.out.println(solution.combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    System.out.println(solution.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
  }
}
