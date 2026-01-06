package com.example.leetcode;

// 700.二叉搜索树中的搜索
// https://leetcode.cn/problems/search-in-a-binary-search-tree/
public class Solution700 {
  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null) {
      if (root.val > val) root = root.left;
      else if (root.val < val) root = root.right;
      else return root;
    }
    return null;
  }

  public TreeNode searchBST2(TreeNode root, int val) {
    if (root == null || root.val == val) return root;
    if (root.val > val) return searchBST(root.left, val);
    else return searchBST(root.right, val);
  }
}
