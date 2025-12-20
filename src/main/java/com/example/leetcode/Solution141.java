package com.example.leetcode;

public class Solution141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    // 初始化快慢两个指针
    ListNode fast = head, slow = head;
    // 如果快指针到达链表尾部，该链表就不是环形链表
    while (fast.next != null && fast.next.next != null) {
      // 快指针每次移动2个节点
      fast = fast.next.next;
      // 慢指针每次移动1个节点
      slow = slow.next;
      // 当快指针追上慢指针（套圈了），证明该链表就是环形链表
      if (fast == slow) {
        return true;
      }
    }
    return false;
  }
}
