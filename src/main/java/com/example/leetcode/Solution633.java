package com.example.leetcode;

public class Solution633 {
  public boolean judgeSquareSum(int c) {
    // 因为Math.sqrt返回double类型，b用int类型会溢出，所以用long类型
    long a = 0;
    long b = (long) Math.sqrt(c);
    while (a <= b) {
      long sum = a * a + b * b;
      if (sum == c) return true;
      // 当sum小于c，增大a
      else if (sum < c) a++;
      // 当sum大于c，减少b
      else b--;
    }
    return false;
  }
}
