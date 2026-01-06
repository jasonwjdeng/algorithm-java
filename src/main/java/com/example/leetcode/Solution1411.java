package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1411. 给 N x 3 网格图涂色的方案数
// https://leetcode.cn/problems/number-of-ways-to-paint-n-3-grid/
public class Solution1411 {
  static final int MOD = 1000000007;

  public int numOfWays(int n) {
    // 初始化白名单，key是合法的颜色组合，value是可以邻近的颜色组合
    Map<Integer, Set<Integer>> whiteList = initWhiteList();

    // 每行有3列，每列有3种颜色选择
    // 3列的颜色组合就是3*3*3=27种
    // 用一个三进制的数字来表示颜色组合
    // 假设每种颜色是0,1,2，颜色组合就是0到26
    int colorCount = 27;
    // dp[i][j]代表第i行是颜色组合j的方案数
    int[][] dp = new int[n + 1][colorCount];
    // 初始化dp数组
    // 对于第1行，因为没有前一行的限制，所以所有合法的颜色组合都符合方案
    for (int j = 0; j < colorCount; j++) {
      if (!whiteList.containsKey(j)) continue;
      dp[1][j] = 1;
    }

    // 从第2行开始遍历
    for (int i = 2; i <= n; i++) {
      // 找出合法的颜色组合j
      for (int j = 0; j < colorCount; j++) {
        if (!whiteList.containsKey(j)) continue;
        // 找出可以邻近的颜色组合k
        for (int k = 0; k < colorCount; k++) {
          if (whiteList.get(j).contains(k)) {
            // 如果第(i-1)行的颜色组合k跟第i行的颜色组合j可以邻近
            // 第i行的j颜色组合的方案数，就是第(i-1)行所有可以邻近k颜色组合的方案数之和
            dp[i][j] += dp[i - 1][k];
            dp[i][j] %= MOD;
          }
        }
      }
    }

    // 计算第n行所有颜色组合的方案数之和，即为最终解
    int count = 0;
    for (int i = 0; i < colorCount; i++) {
      count += dp[n][i];
      count %= MOD;
    }
    return count;
  }

  private static Map<Integer, Set<Integer>> initWhiteList() {
    Map<Integer, Set<Integer>> whiteList = new HashMap<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          // 邻近两列颜色不能相同
          if (i == j || j == k) continue;
          // 计算颜色组合编码
          int color = 9 * i + 3 * j + k;
          whiteList.put(color, new HashSet<>());
          for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
              for (int z = 0; z < 3; z++) {
                // 邻近两列颜色不能相同
                if (x == y || y == z) continue;
                // 邻近两行颜色不能相同
                if (i == x || j == y || k == z) continue;
                // 计算可以与color相邻的颜色组合编码
                whiteList.get(color).add(9 * x + 3 * y + z);
              }
            }
          }
        }
      }
    }
    return whiteList;
  }

//  int[] dp;
//  Map<Integer, Set<Integer>> whiteList;
//  Map<String, Integer> memo;
//
//  public int numOfWays(int n) {
//    dp = new int[n];
//    Arrays.fill(dp, -1);
//    whiteList = initWhiteList();
//    memo = new HashMap<>();
//    //    System.out.println(whiteList);
//    return backtrack(n, 0, 0);
//  }
//
//  private int backtrack(int n, int index, int color) {
//    //    System.out.println(index);
//    //    System.out.println(Arrays.toString(dp));
////    System.out.println(memo);
//    String key = index + "," + color;
//    if (memo.containsKey(key)) return memo.get(key);
//    if (index == n) {
//      memo.put(key, 1);
//      return 1;
//    }
//    int count = 0;
//    for (int i = 0; i < 27; i++) {
//      if (!whiteList.containsKey(i)) continue;
//      if (index > 0 && !whiteList.get(i).contains(dp[index - 1])) continue;
//      dp[index] = i;
//      count += backtrack(n, index + 1, i);
//      count %= MOD;
//      dp[index] = -1;
//    }
//    memo.put(key, count);
//    return count;
//  }

  public static void main(String[] args) {
    Solution1411 solution = new Solution1411();
    System.out.println(solution.numOfWays(1)); // 12
    System.out.println(solution.numOfWays(2)); // 54
        System.out.println(solution.numOfWays(3)); // 246
        System.out.println(solution.numOfWays(7)); // 106494
        System.out.println(solution.numOfWays(5000)); // 30228214
  }
}
