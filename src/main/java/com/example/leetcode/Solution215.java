package com.example.leetcode;

public class Solution215 {
  public int findKthLargest(int[] nums, int k) {
    // 构造大根堆
    int len = nums.length;
    for (int i = len / 2; i >= 0; i--) {
      sink(nums, i, len);
    }

    // 弹出堆顶k-1个元素并重新构造大根堆
    for (int i = 1; i < k; i++) {
      swap(nums, 0, --len);
      sink(nums, 0, len);
    }

    // 这时堆顶便是第k个最大元素
    return nums[0];
  }

  private void sink(int[] nums, int k, int len) {
    int root = k;
    for (int sub = root * 2 + 1; sub < len; sub = root * 2 + 1) {
      if (sub + 1 < len && larger(nums, sub + 1, sub)) sub++;
      if (!larger(nums, sub, root)) break;
      swap(nums, root, sub);
      root = sub;
    }
  }

  private static boolean larger(int[] nums, int i, int j) {
    return nums[i] > nums[j];
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[j];
    nums[j] = nums[i];
    nums[i] = temp;
  }

  public static void main(String[] args) {
    Solution215 solution = new Solution215();
    int result = solution.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    System.out.println(result); // 4
  }
}
