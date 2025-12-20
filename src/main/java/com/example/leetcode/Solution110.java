package com.example.leetcode;

public class Solution110 {
  /** 递归（自底向上） */
  public boolean isBalanced1(TreeNode root) {
    return helper(root) >= 0;
  }

  private int helper(TreeNode root) {
    // 根节点为空，返回树的深度为0
    if (root == null) return 0;
    // 计算左右子树深度
    int left = helper(root.left);
    int right = helper(root.right);
    // 左子树不平衡，或者右子树不平衡，或者左右子树高度差大于1
    if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
      return -1;
    }
    // 返回树的深度
    return 1 + Math.max(left, right);
  }

  /** 递归（自顶向下） */
  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    } else {
      return Math.abs(height(root.left) - height(root.right)) <= 1
          && isBalanced(root.left)
          && isBalanced(root.right);
    }
  }

  public int height(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      return Math.max(height(root.left), height(root.right)) + 1;
    }
  }
}
