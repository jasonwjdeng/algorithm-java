package com.example.leetcode;

import java.util.Arrays;

// 300.最长递增子序列
// https://leetcode.cn/problems/longest-increasing-subsequence/
public class Solution300 {
  public int lengthOfLIS(int[] nums) {
    int[] top = new int[nums.length];
    // 牌堆数初始化为 0
    int piles = 0;
    for (int poker : nums) {
      // 要处理的扑克牌
      // ***** 搜索左侧边界的二分查找 *****
      int left = 0, right = piles;
      while (left < right) {
        int mid = (left + right) / 2;
        if (top[mid] > poker) {
          right = mid;
        } else if (top[mid] < poker) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      // *********************************

      // 没找到合适的牌堆，新建一堆
      if (left == piles) piles++;
      // 把这张牌放到牌堆顶
      top[left] = poker;
    }
    // 牌堆数就是 LIS 长度
    return piles;
  }

  public int lengthOfLIS2(int[] nums) {
    // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
    int[] dp = new int[nums.length];
    // dp 数组全都初始化为 1
    Arrays.fill(dp, 1);

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        // 寻找 nums[0..i-1] 中比 nums[i] 小的元素
        if (nums[i] > nums[j]) {
          // 把 nums[i] 接在后面，即可形成长度为 dp[j] + 1，
          // 且以 nums[i] 为结尾的递增子序列
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    // 根据dp定义，我们的最终结果（子序列的最大长度）应该是 dp 数组中的最大值。
    int result = 1;
    for (int i : dp) {
      result = Math.max(result, i);
    }
    return result;
  }
}
