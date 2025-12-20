package com.example.leetcode;

public class Solution101 {
  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return compare(root.left, root.right);
  }

  private boolean compare(TreeNode left, TreeNode right) {
    // 左右子节点都为空，对称
    if (left == null && right == null) {
      return true;
    }
    // 左右子节点任一个为空，不对称
    if (left == null || right == null) {
      return false;
    }
    // 左右子节点值不相等，不对称
    if (left.val != right.val) {
      return false;
    }
    // 递归比较左右子树
    return compare(left.left, right.right) && compare(left.right, right.left);
  }
}
