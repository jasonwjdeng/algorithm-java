package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 39. 组合总和
// https://leetcode.cn/problems/combination-sum/
public class Solution39 {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
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
    for (int i = index; i < candidates.length; i++) {
      if (sum + candidates[i] > target) continue;
      choices.add(candidates[i]);
      backtracking(candidates, target, i, result, choices, sum + candidates[i]);
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution39 solution = new Solution39();
    System.out.println(solution.combinationSum(new int[] {2, 3, 6, 7}, 7));
  }
}
