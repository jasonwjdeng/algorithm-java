package com.example.leetcode;

public class Solution234 {
  public boolean isPalindrome(ListNode head) {
    // find the middle list node
    ListNode fast = head, slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    // reverse 2nd half
    ListNode firstEnd = slow;
    ListNode temp = reverse(firstEnd.next);

    // compare 1st and 2nd half
    slow = temp;
    fast = head;
    boolean result = true;
    while (fast != null && slow != null) {
      if (fast.val != slow.val) {
        result = false;
        break;
      }
      fast = fast.next;
      slow = slow.next;
    }

    // recover list
    firstEnd.next = reverse(temp);

    return result;
  }

  private ListNode reverse(ListNode head) {
    ListNode cur = head;
    ListNode prev = null;
    while (cur != null) {
      ListNode next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
