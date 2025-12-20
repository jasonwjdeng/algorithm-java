package com.example.leetcode;

public class SolutionOffer22 {
  public int kthToLast(ListNode head, int k) {
    ListNode fast = head;
    // 快指针移动第k个元素的位置
    while (k-- > 0) {
      fast = fast.next;
    }
    ListNode slow = head;
    // 慢指针跟快指针同步移动，当快指针到达链表尾部，退出循环
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    // 这时慢指针刚好就指向倒数第k个元素的位置
    return slow.val;
  }
}
