package com.example.leetcode;

public class Solution142 {
  public ListNode detectCycle(ListNode head) {
    if (head == null) return head;
    // 初始化快慢两个指针
    ListNode fast = head, slow = head;
    // 如果快指针到达链表尾部，该链表就不是环形链表
    while (fast.next != null && fast.next.next != null) {
      // 慢指针每次移动1个节点
      slow = slow.next;
      // 快指针每次移动2个节点
      fast = fast.next.next;
      // 当快指针追上慢指针（套圈了），证明该链表就是环形链表
      if (slow == fast) {
        // 当快慢指针相遇时，p从链表头开始，与慢指针同步移动1个节点
        ListNode p = head;
        // 当p追上慢指针时，此时的节点便是入环的第一个节点
        while (slow != p) {
          slow = slow.next;
          p = p.next;
        }
        return slow;
      }
    }
    return null;
  }
}
