package com.example.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

// 135.分发糖果
// https://leetcode.cn/problems/candy/
public class Solution135 {
  public int candy(int[] ratings) {
    int[] candies = new int[ratings.length];
    Arrays.fill(candies, 1);
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
    }
    for (int i = ratings.length - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1);
    }
    return IntStream.of(candies).sum();
  }

  public static void main(String[] args) {
    Solution135 solution = new Solution135();
    System.out.println(solution.candy(new int[] {1, 0, 2})); // 5
    System.out.println(solution.candy(new int[] {1, 2, 2})); // 4
  }
}
