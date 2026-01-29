package com.example.leetcode;

import java.util.HashMap;
import java.util.Map;

// 337. 打家劫舍 III
// https://leetcode.cn/problems/house-robber-iii/
// 提示：
// 树的节点数在 [1, 10^4] 范围内
// 0 <= Node.val <= 10^4
public class Solution337 {
  // 耗时1ms,击败88.29%
  public int rob(TreeNode root) {
    // dp数组（dp table）以及下标的含义：下标为0记录不偷该节点所得到的的最大金钱，下标为1记录偷该节点所得到的的最大金钱。
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
  }

  public int[] helper(TreeNode root) {
    int[] result = new int[2];
    if (root == null) return result;
    // 不偷root
    // 通过递归左节点，得到左节点偷与不偷的金钱。
    // 通过递归右节点，得到右节点偷与不偷的金钱。
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    // 偷root，不偷left和right
    result[1] = root.val + left[0] + right[0];
    return result;
  }

  Map<TreeNode, Integer> memo = new HashMap<>();

  // 递归+memo，耗时3ms，击败18.33%
  public int rob2(TreeNode root) {
    if (root == null) return 0;
    if (memo.containsKey(root)) return memo.get(root);
    if (root.left == null && root.right == null) {
      memo.put(root, root.val);
      return root.val;
    }
    int x = root.val;
    if (root.left != null) x += rob(root.left.left) + rob(root.left.right);
    if (root.right != null) x += rob(root.right.left) + rob(root.right.right);
    int y = rob(root.left) + rob(root.right);
    int max = Math.max(x, y);
    memo.put(root, max);
    return max;
  }

  // 递归，计算超时
  public int rob3(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return root.val;
    int x = root.val;
    if (root.left != null) x += rob(root.left.left) + rob(root.left.right);
    if (root.right != null) x += rob(root.right.left) + rob(root.right.right);
    int y = rob(root.left) + rob(root.right);
    return Math.max(x, y);
  }
}
