package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution144 {
  /** 通过循环迭代+栈的方式解答 */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        result.add(root.val); // 访问根节点
        stack.push(root); // 把根节点压栈
        root = root.left; // 遍历左子树
      }
      root = stack.pop(); // 左子树访问完后，弹出根节点
      root = root.right; // 遍历右子树
    }
    return result;
  }

  /** 用递归方式解答 */
  public List<Integer> preorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(result, root);
    return result;
  }

  private void traverse(List<Integer> result, TreeNode root) {
    if (root == null) return;
    result.add(root.val); // 访问根节点
    traverse(result, root.left); // 遍历左子树
    traverse(result, root.right); // 遍历右子树
  }
}
