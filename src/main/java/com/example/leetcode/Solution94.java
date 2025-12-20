package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution94 {
  /** 通过循环迭代+栈的方式解答 */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root); // 把根节点压栈
        root = root.left; // 遍历左子树
      }
      root = stack.pop(); // 弹出根节点
      result.add(root.val); // 访问根节点
      root = root.right; // 遍历右子树
    }
    return result;
  }

  /** 用递归方式解答 */
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(result, root);
    return result;
  }

  private void traverse(List<Integer> result, TreeNode root) {
    if (root == null) return;
    traverse(result, root.left);
    result.add(root.val);
    traverse(result, root.right);
  }
}
