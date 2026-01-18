package com.example.leetcode;

import java.util.Arrays;

// 354. 俄罗斯套娃信封问题
// https://leetcode.cn/problems/russian-doll-envelopes/
public class Solution354 {
  public int maxEnvelopes(int[][] envelopes) {
    //    int[] nums =
    //        Arrays.stream(envelopes)
    //            .sorted((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0])
    //            .mapToInt(o -> o[1])
    //            .toArray();
    // 按宽度升序排列，如果宽度一样，则按高度降序排列
    Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
    // 对高度数组寻找 LIS
    int[] nums = new int[envelopes.length];
    for (int i = 0; i < envelopes.length; i++) {
      nums[i] = envelopes[i][1];
    }
    return lengthOfLIS(nums);
  }

  // See Solution300
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

  public static void main(String[] args) {
    Solution354 solution = new Solution354();
    System.out.println(solution.maxEnvelopes(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}})); // 3
  }

  // 超时
  public int maxEnvelopes2(int[][] envelopes) {
    Arrays.sort(envelopes, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

    int[] dp = new int[envelopes.length];
    Arrays.fill(dp, 1);

    for (int i = 0; i < envelopes.length; i++) {
      for (int j = 0; j < i; j++) {
        if (envelopes[i][1] > envelopes[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    int result = 1;
    for (int i : dp) {
      result = Math.max(result, i);
    }
    return result;
  }
}
