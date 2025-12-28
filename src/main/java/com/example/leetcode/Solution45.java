package com.example.leetcode;

// 45.跳跃游戏II
// https://leetcode.cn/problems/jump-game-ii
public class Solution45 {
  public int jump(int[] nums) {
    // 记录走的最大步数
    int count = 0;
    // 当前覆盖的最远距离下标
    int end = 0;
    // 下一步覆盖的最远距离下标
    int distance = 0;
    // 因为当移动下标指向 nums.size - 2 时：
    // - 如果移动下标等于当前覆盖最大距离下标， 需要再走一步（即 count++），因为最后一步一定是可以到的终点。(题目假设总是可以到达数组的最后一个位置)
    // - 如果移动下标不等于当前覆盖最大距离下标，说明当前覆盖最远距离就可以直接达到终点了，不需要再走一步。
    for (int i = 0; i < nums.length - 1; i++) {
      // 更新下一步覆盖的最远距离下标
      distance = Math.max(distance, i + nums[i]);
      System.out.printf("i=%d,end=%d,distance=%d,count=%d%n", i, end, distance, count);
      // 遇到当前覆盖的最远距离下标
      if (i == end) {
        // 更新当前覆盖的最远距离下标
        end = distance;
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Solution45 solution = new Solution45();
    System.out.println(solution.jump(new int[] {2, 3, 1, 1, 1}));
  }
}
