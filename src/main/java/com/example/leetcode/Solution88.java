package com.example.leetcode;

import java.util.Arrays;

public class Solution88 {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, tail = m + n - 1;
    while (i >= 0 || j >= 0) {
      if (i < 0) {
        // 当nums1耗尽，把nums2剩余元素复制到nums1
        nums1[tail--] = nums2[j--];
      } else if (j < 0) {
        // 当nums2耗尽，把nums1剩余元素复制到nums1
        // nums1[tail--] = nums1[i--];
        // 当nums2耗尽，把nums1剩余元素便是最小的几个元素，退出循环
        break;
      } else if (nums1[i] < nums2[j]) {
        // 当nums2比nums1大，把nums2复制到nums1
        nums1[tail--] = nums2[j--];
      } else {
        // 当nums1大于等于nums2，把nums1复制到nums1
        nums1[tail--] = nums1[i--];
      }
    }
  }

  public void merge2(int[] nums1, int m, int[] nums2, int n) {
    // 因为最终结果要放到nums1，所以复制nums1用作下面的比较
    int[] nums1copy = Arrays.copyOf(nums1, nums1.length);
    // i指向nums1copy的元素，j指向nums2的元素，k指向待插入nums1元素的位置
    int i = 0, j = 0, k = 0;
    // 当nums1copy和nums2都遍历完就退出循环
    while (i < m || j < n) {
      if (i == m) {
        // 如果nums1已经遍历完，把nums2剩余元素全部复制到nums1
        nums1[k++] = nums2[j++];
      } else if (j == n) {
        // 如果nums2已经遍历完，把nums1copy剩余元素全部复制到nums1
        nums1[k++] = nums1copy[i++];
      } else if (nums1copy[i] < nums2[j]) {
        // 如果nums1copy小于nums2，就把nums1copy复制到nums1
        nums1[k++] = nums1copy[i++];
      } else {
        // 如果nums1copy大于等于nums2，就nums2复制到nums1
        nums1[k++] = nums2[j++];
      }
    }
  }
}
