package com.example.leetcode;

public class Solution226 {
  public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    // 先分别翻转左右子树
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    // 再交换左右子树
    root.left = right;
    root.right = left;
    return root;
  }
}
