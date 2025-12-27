package com.example.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 102. 二叉树的层序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/ */
public class Solution102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    // 构造节点队列
    Queue<TreeNode> queue = new LinkedList<>();
    // 把根节点放进队列
    queue.offer(root);
    // 从根节点开始逐层遍历
    int level = 0;
    int depth = 1;
    while (!queue.isEmpty()) {
      List<Integer> list = new ArrayList<>();
      // size就是同一层次的节点个数
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        // 访问同一层次的节点
        TreeNode node = queue.poll();
        list.add(node.val);
        System.out.printf("node=%d,level=%d,depth=%d", node.val, level, depth);
        // 把下一层次的节点放进队列
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      // 访问完一层节点，把节点列表放进最终结果
      result.add(list);
      level++;
      depth++;
    }
    return result;
  }
}
