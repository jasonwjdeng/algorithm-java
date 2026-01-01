package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 16. 组合总和 III
// https://leetcode.cn/problems/combination-sum-iii/
public class Solution216 {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    backtracking(k, n, 1, 9, result, list);
    return result;
  }

  private void backtracking(
      int k, int n, int start, int end, List<List<Integer>> result, List<Integer> list) {
//    System.out.printf("k=%d,n=%d,start=%d,end=%d,list=%d%n", k, n, start, end, list.size());

    int size = list.size();
    if (size == k) {
      int sum = 0;
      for (Integer i : list) {
        sum += i;
      }
      if (sum == n) {
        result.add(new ArrayList<>(list));
        return;
      } else if (sum > n) return;
    }

    for (int i = start; i <= end - k + size + 1 && size < k; i++) {
      list.add(i);
      backtracking(k, n, i + 1, end, result, list);
      list.removeLast();
    }
  }

  public static void main(String[] args) {
    Solution216 solution = new Solution216();
    System.out.println(solution.combinationSum3(3, 7));
    //    System.out.println(solution.combinationSum3(3,9));
  }
}
