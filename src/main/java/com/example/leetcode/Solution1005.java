package com.example.leetcode;

import java.util.stream.IntStream;

// 1005. K 次取反后最大化的数组和
// https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations
public class Solution1005 {
  // 题目中限定了数据范围nums[i]是[-100,100]，所以可以利用桶排序的优化算法，时间复杂度为O(N)
  public int largestSumAfterKNegations(int[] nums, int k) {
    // 初始化桶
    int[] bucket = new int[201];
    // 用桶来计数每个整数的出现次数
    for (int num : nums) {
      bucket[num + 100]++;
    }

    // 将尽可能多的绝对值大的负数翻转
    for (int i = 0; i < 100; i++) {
      if (bucket[i] > 0 && k > 0) {
        int ops = Math.min(k, bucket[i]);
        bucket[i] -= ops;
        bucket[200 - i] += ops; // i-100的相反数为100-i，再+100放入数组下标，为200-i
        k -= ops;
      }
    }

    // 如果还需要翻转（此时数组中已不含负数），就将最小的非负数翻转
    if (k % 2 == 1) {
      for (int i = 100; i < 201; i++) {
        if (bucket[i] > 0) {
          bucket[i]--;
          bucket[200 - i]++;
          break;
        }
      }
    }

    // 计算总和
    int ans = 0;
    for (int i = 0; i < 201; i++) {
      ans += (bucket[i] * (i - 100)); // bucket[i]为i-100这个数对应的个数
    }
    return ans;
  }

  // 因为用了快排，所以时间复杂度为O(NlogN)
  public int largestSumAfterKNegations2(int[] nums, int k) {
    // 把数组按照绝对值从大到小排序
    nums =
        IntStream.of(nums)
            .boxed()
            .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
            .mapToInt(Integer::intValue)
            .toArray();
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      // 尽可能将将绝对值最大的负数变成正数
      if (nums[i] < 0 && k > 0) {
        nums[i] = -nums[i];
        k--;
      }
    }
    // 如果还需要翻转（此时数组中已不含负数），
    // 就将绝对值最小的值翻转
    if (k % 2 == 1) {
      nums[length - 1] = -nums[length - 1];
    }
    return IntStream.of(nums).sum();
  }

  public static void main(String[] args) {
    Solution1005 solution = new Solution1005();
    System.out.println(solution.largestSumAfterKNegations(new int[] {4, 2, 3}, 1)); // 5
    System.out.println(solution.largestSumAfterKNegations(new int[] {3, -1, 0, 2}, 3)); // 6
    System.out.println(solution.largestSumAfterKNegations(new int[] {2, -3, -1, 5, -4}, 2)); // 13
  }
}
