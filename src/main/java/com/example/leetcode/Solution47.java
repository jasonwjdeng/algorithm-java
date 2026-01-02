package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 47.全排列II
// https://leetcode.cn/problems/permutations-ii/
public class Solution47 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    backtracking(nums, used, result, choices);
    return result;
  }

  private void backtracking(
      int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> choices) {
    // 当所有元素都被选择即为一个解
    if (choices.size() == nums.length) {
      result.add(new ArrayList<>(choices));
      return;
    }
    Set<Integer> set = new HashSet<>();
    // 从头遍历整个数组
    for (int i = 0; i < nums.length; i++) {
      //如果该元素已经在choices里面，或者同一层次的相同元素，就跳过
      if (used[i] || set.contains(nums[i])) continue;
      // 选择一个新的元素
      choices.add(nums[i]);
      used[i] = true;
      set.add(nums[i]);
      // 从头开始递归遍历
      backtracking(nums, used, result, choices);
      // 撤销当前选择
      choices.removeLast();
      used[i] = false;
    }
  }

  public static void main(String[] args) {
    Solution47 solution = new Solution47();
    System.out.println(solution.permute(new int[] {1, 1, 2}));
    System.out.println(solution.permute(new int[] {1, 2, 3}));
  }
}
