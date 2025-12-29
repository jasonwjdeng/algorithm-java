package com.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution406 {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(
        people,
        (o1, o2) -> {
          // 相同身高按照属性升序排列
          if (o1[0] == o2[0]) return o1[1] - o2[1];
          // 按升高降序排列
          else return o2[0] - o1[0];
        });
    List<int[]> queue = new LinkedList<>();
    for (int[] p : people) {
      // 按照属性插入到队列中
      queue.add(p[1], p);
    }
    return queue.toArray(new int[people.length][]);
  }
}
