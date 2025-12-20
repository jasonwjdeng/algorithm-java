package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution347 {
  public int[] topKFrequent(int[] nums, int k) {
    // 计算每个元素的出现频率
    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int num : nums) {
      int frequency = frequencies.getOrDefault(num, 0);
      frequencies.put(num, ++frequency);
    }

    // 利用优先队列构造一个大根堆
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
      queue.offer(new int[] {entry.getKey(), entry.getValue()});
    }

    // 弹出k个堆顶元素即为题解
    int[] result = new int[k];
    for (int i = 0; i < k; i++) {
      result[i] = queue.poll()[0];
    }
    return result;
  }

  public static void main(String[] args) {
    Solution347 solution = new Solution347();
    int[] result = solution.topKFrequent(new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, 2);
    System.out.println(Arrays.toString(result)); // [1,2]
  }
}
