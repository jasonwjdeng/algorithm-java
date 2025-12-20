package com.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution104 {
  /** 递归（深度优先搜索） */
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  /** 循环迭代+队列（广度优先搜索） */
  public int maxDepth2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int ans = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size > 0) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
        size--;
      }
      ans++;
    }
    return ans;
  }
}
