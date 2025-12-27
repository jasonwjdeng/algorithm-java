package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/** 590. N 叉树的后序遍历 https://leetcode.cn/problems/n-ary-tree-postorder-traversal */
public class Solution590 {
  public List<Integer> postorder(Node root) {
    List<Integer> result = new ArrayList<>();
    postorder(root, result);
    return result;
  }

  private void postorder(Node root, List<Integer> result) {
    if (root == null) return;
    // 先然后从左到右逐个子树访问
    for (Node child : root.children) {
      postorder(child, result);
    }
    // 然后访问根节点
    result.add(root.val);
  }
}
