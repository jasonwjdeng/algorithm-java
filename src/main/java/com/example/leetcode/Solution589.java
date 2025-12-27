package com.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/** 589. N 叉树的前序遍历 https://leetcode.cn/problems/n-ary-tree-preorder-traversal */
public class Solution589 {
  //  public List<Integer> preorder(Node root) {
  //    List<Integer> res = new ArrayList<>();
  //    if (root == null) return res;
  //    Stack<Node> st = new Stack<>();
  //    st.push(root);
  //    while (!st.isEmpty()) {
  //      Node n = st.pop();
  //      res.add(n.val);
  //      for (int i = n.children.size() - 1; i >= 0; i--) {
  //        st.push(n.children.get(i));
  //      }
  //    }
  //    return res;
  //  }
  //  public List<Integer> preorder(Node root) {
  //    List<Integer> result = new ArrayList<>();
  //    if (root == null) return result;
  //    LinkedList<Node> stack = new LinkedList<>();
  //    Map<Node, Integer> map = new HashMap<>();
  //    Node node = root;
  //    // 当所有节点都遍历完，退出循环
  //    while (!stack.isEmpty() || node != null) {
  //      // 访问根节点，遍历第一个子节点
  //      while (node != null) {
  //        // 访问根节点
  //        result.add(node.val);
  //        // 把根节点压栈
  //        stack.push(node);
  //        // 遍历第一个子节点
  //        List<Node> children = node.children;
  //        if (children != null && !children.isEmpty()) {
  //          map.put(node, 0);
  //          node = children.getFirst();
  //        } else {
  //          // 当最左边叶子结点访问完，退出内循环
  //          node = null;
  //        }
  //      }
  //      // 回到最左边叶子节点的根节点
  //      node = stack.peek();
  //      //读取访问过的最大的孩子索引，加1表示准备访问下个孩子
  //      int index = map.getOrDefault(node, -1) + 1;
  //      List<Node> children = node.children;
  //      if (children != null && children.size() > index) {
  //        //如果存在index索引指向的孩子，更新map
  //        map.put(node, index);
  //        //准备访问该孩子节点
  //        node = children.get(index);
  //      } else {
  //        //所有孩子节点都访问完了，弹出根节点
  //        stack.pop();
  //        //从map移出该根节点的访问记录
  //        map.remove(node);
  //        //该根节点为根的子树访问完毕
  //        node = null;
  //      }
  //    }
  //    return result;
  //  }

  public List<Integer> preorder(Node root) {
    List<Integer> result = new ArrayList<>();
    preorder(root, result);
    return result;
  }

  private void preorder(Node root, List<Integer> result) {
    if (root == null) return;
    // 先访问根节点
    result.add(root.val);
    // 然后从左到右逐个子树访问
    for (Node child : root.children) {
      preorder(child, result);
    }
  }
}
