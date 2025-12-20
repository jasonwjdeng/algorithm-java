package com.example.leetcode;

public class Solution876 {
  public ListNode middleNode(ListNode head) {
    ListNode fast = head, slow = head;
    // 快指针每次移动2个节点，慢指针每次移动1个节点
    // 当快指针到达链表尾部时候，慢指针刚好就在中间节点位置
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
