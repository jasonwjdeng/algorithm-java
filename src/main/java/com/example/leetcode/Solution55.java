package com.example.leetcode;

// 55. 跳跃游戏
// https://leetcode.cn/problems/jump-game
public class Solution55 {
  public boolean canJump(int[] nums) {
    //定义能走的最远距离
    int distance = 0;
    //逐步走到最近一次计算的最远距离
    for (int i = 0; i <= distance; i++) {
      //如果发现能走的更远，更新distance
      distance = Math.max(distance, i + nums[i]);
      //如果最远距离覆盖最后一个元素，证明能到达最后一个位置
      if (distance >= nums.length - 1) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution55 solution = new Solution55();
    System.out.println(solution.canJump(new int[] {2, 0}));
  }
}
