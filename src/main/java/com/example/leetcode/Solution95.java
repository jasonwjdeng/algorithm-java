package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

// 95. 不同的二叉搜索树 II
// https://leetcode.cn/problems/unique-binary-search-trees-ii/
public class Solution95 {
  List<TreeNode>[][] memo;

  public List<TreeNode> generateTrees(int n) {
    memo = new List[n + 2][n + 2];
    return generateTrees(1, n);
  }

  public List<TreeNode> generateTrees(int start, int end) {
    if (null != memo[start][end]) return memo[start][end];
    List<TreeNode> result = new ArrayList<>();
    if (start > end) {
      //不存在这种情况，表示没有子树
      result.add(null);
      return result;
    }
    // 构造以i为根的树
    for (int i = start; i <= end; i++) {
      // 构造所有以(start,i-1)为节点的左子树
      List<TreeNode> left = generateTrees(start, i - 1);
      // 构造所有以(i+1,end)为节点的右子树
      List<TreeNode> right = generateTrees(i + 1, end);
      // 遍历各种左右子树，构造i为根的树
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          result.add(new TreeNode(i, l, r));
        }
      }
    }
    memo[start][end] = result;
    return result;
  }
}
