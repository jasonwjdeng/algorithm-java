package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
  public String frequencySort(String s) {
    // 计算每个字符的出现频率
    Map<Character, Integer> frequencies = new HashMap<>();
    for (char c : s.toCharArray()) {
      int frequency = frequencies.getOrDefault(c, 0);
      frequencies.put(c, ++frequency);
    }

    // 根据频率堆字符进行排序
    List<Character> chars = new ArrayList<>(frequencies.keySet());
    chars.sort((o1, o2) -> frequencies.get(o2).compareTo(frequencies.get(o1)));

    // 根据排好序的字符构造结果字符串
    StringBuilder sb = new StringBuilder();
    for (Character c : chars) {
      sb.append(String.valueOf(c).repeat(Math.max(0, frequencies.get(c))));
    }
    return sb.toString();
  }

  public String frequencySort2(String s) {
    // 计算每个字符的出现频率
    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int c : s.toCharArray()) {
      int frequency = frequencies.getOrDefault(c, 0);
      frequencies.put(c, ++frequency);
    }

    // 利用优先队列构造一个大根堆
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
      queue.offer(new int[] {entry.getKey(), entry.getValue()});
    }

    // 弹出堆顶构造结果字符串
    byte[] result = new byte[s.length()];
    int cur = 0;
    for (int i = 0; i < queue.size(); ) {
      int[] a = queue.poll();
      for (int j = 0; j < a[1]; j++) {
        result[cur++] = (byte) a[0];
      }
    }
    return new String(result);
  }

  public static void main(String[] args) {
    Solution451 solution = new Solution451();
    String result = solution.frequencySort("raaeaedere");
    System.out.println(result);
  }
}
