package com.example.leetcode;

// 376.摆动序列
// https://leetcode.cn/problems/wiggle-subsequence/
public class Solution376 {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return 1;
    int preDiff = 0, curDiff = 0;
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      curDiff = nums[i] - nums[i - 1];
      if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
        result++;
        preDiff = curDiff;
      }
    }

    return result;
  }
}
