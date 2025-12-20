package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution145 {
  /** 通过循环迭代+栈的方式解答 */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode prevAccess = null;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root); // 把根节点压栈
        root = root.left; // 遍历左子树
      }
      root = stack.pop(); // 弹出根节点
      if (root.right == null // 没有右子树
          || root.right == prevAccess // 右子树访问过了
      ) {
        result.add(root.val); // 访问根节点
        prevAccess = root; // 标记右子树已访问
        root = null; // 标记右子树访问完，下个循环将弹出父节点
      } else {
        stack.push(root); // 把根节点压栈
        root = root.right; // 遍历右子树
      }
    }
    return result;
  }

  /** 用递归方式解答 */
  public List<Integer> postorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    traverse(result, root);
    return result;
  }

  private void traverse(List<Integer> result, TreeNode root) {
    if (root == null) return;
    traverse(result, root.left); // 遍历左子树
    traverse(result, root.right); // 遍历右子树
    result.add(root.val); // 访问根节点
  }
}
