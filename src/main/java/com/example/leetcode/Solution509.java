package com.example.leetcode;


// 509.斐波那契数
// https://leetcode.cn/problems/fibonacci-number
public class Solution509 {
  //  public int fib(int n) {
  //    if (n == 0 || n == 1) return n;
  //    return fib(n - 1) + fib(n - 2);
  //  }

  //  Map<Integer, Integer> memo = new HashMap<>();

  //  public int fib(int n) {
  //    if (n == 0 || n == 1) return n;
  //    if (memo.containsKey(n)) return memo.get(n);
  //    int val = fib(n - 1) + fib(n - 2);
  //    memo.put(n, val);
  //    return val;
  //  }

  //  public int fib(int n) {
  //    if (n == 0 || n == 1) return n;
  //    int[] dp = new int[n + 1];
  //    dp[0] = 0;
  //    dp[1] = 1;
  //    for (int i = 2; i <= n; i++) {
  //      dp[i] = dp[i - 1] + dp[i - 2];
  //    }
  //    return dp[n];
  //  }

  public int fib(int n) {
    if (n == 0 || n == 1) return n;
    int p = 0, q = 0, r = 1;
    for (int i = 2; i <= n; i++) {
      p = q;
      q = r;
      r = p + q;
    }
    return r;
  }
}
