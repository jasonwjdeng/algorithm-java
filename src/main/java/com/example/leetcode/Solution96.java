package com.example.leetcode;

import java.util.Arrays;

// 96. 不同的二叉搜索树
// https://leetcode.cn/problems/unique-binary-search-trees/
public class Solution96 {
  public int numTrees(int n) {
    // 定义dp数组，下标表示i个不同节点组成的的BST的数量
    int[] dp = new int[n + 1];
    // 初始化dp[0]，表示0个节点的树是也算是一棵BST
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        // i个不同节点的BST的数量是所有[(j-1)个节点的左子树]*[(i-j)个节点的右子树]的数量
        // 即：dp[i]=dp[0]*dp[i-1]+dp[1]*dp[i-2]+...+dp[i-2]*dp[1]+dp[i-1]*dp[0]
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }
    //    System.out.println(Arrays.toString(dp));
    // 返回n个不同节点组成BST的数量
    return dp[n];
  }

  public static void main(String[] args) {
    Solution96 solution = new Solution96();
    System.out.println(solution.numTrees(3)); // 5
    System.out.println(solution.numTrees(1)); // 1
  }
}
