package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 77. 组合
// https://leetcode.cn/problems/combinations
public class Solution77 {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> choices = new ArrayList<>();
    backtracking(n, k, 1, result, choices);
    return result;
  }

  public void backtracking(
      int n, int k, int start, List<List<Integer>> result, List<Integer> choices) {
    //当选择的元素符合条件个数，把选中的元素加到结果集，终止递归
    if (choices.size() == k) {
      result.add(new ArrayList<>(choices));
      return;
    }
    //遍历所有元素（经过剪枝优化）
    for (int i = start; i <= n - k + choices.size() + 1; i++) {
      //选择当前元素
      choices.add(i);
      //从下个元素开始递归遍历
      backtracking(n, k, i + 1, result, choices);
      //撤销当前选择（准备下个循环选择新的元素）
      choices.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution77 solution = new Solution77();
    System.out.println(solution.combine(4, 2));
    //        System.out.println(solution.combine(1, 1));
  }
}
