package com.example.leetcode;

// 134. 加油站
// https://leetcode.cn/problems/gas-station/
public class Solution134 {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int totalSum = 0; // 总剩余油量
    int curSum = 0; // 区间剩余油量
    int index = 0; // 起点位置
    for (int i = 0; i < gas.length; i++) {
      totalSum += gas[i] - cost[i]; // 累计总剩余油量
      curSum += gas[i] - cost[i]; // 累计区间剩余油量
      if (curSum < 0) {
        // 如果区间剩余油量不足，就以下个油站作为起点。解释：
        // 整个迭代分为两个区间，区间一是已迭代部分，剩余是区间二；
        // 因为如果有解的话(即totalSum>=0)，即使区间一剩余油量不足，区间二剩余油量也能覆盖区间一的不足部分。
        index = i + 1;
        curSum = 0;
      }
    }
    // 如果总剩余油量小于0，证明没法走完一圈
    if (totalSum < 0) return -1;
    return index;
  }
}
