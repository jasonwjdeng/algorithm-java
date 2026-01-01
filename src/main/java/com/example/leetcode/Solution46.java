package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 46.全排列
// https://leetcode.cn/problems/permutations/
public class Solution46 {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    backtracking(nums, result, choices);
    return result;
  }

  private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> choices) {
    //当所有元素都被选择即为一个解
    if (choices.size() == nums.length) {
      result.add(new ArrayList<>(choices));
      return;
    }
    //从头遍历整个数组
    for (int num : nums) {
      //跳过已经选择过的元素
      if (choices.contains(num)) continue;
      //选择一个新的元素
      choices.add(num);
      //从头开始递归遍历
      backtracking(nums, result, choices);
      //撤销当前选择
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution46 solution = new Solution46();
    System.out.println(solution.permute(new int[] {1, 2, 3}));
  }
}
