package com.example.leetcode;

public class Solution83 {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return head;
    ListNode currentNode = head;
    while (currentNode.next != null) {
      if (currentNode.next.val == currentNode.val) {
        currentNode.next = currentNode.next.next;
      } else {
        currentNode = currentNode.next;
      }
    }
    return head;
  }
}
