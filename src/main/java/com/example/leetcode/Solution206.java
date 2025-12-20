package com.example.leetcode;

public class Solution206 {
  public ListNode reverseList(ListNode head) {
    // if (head == null || head.next == null)
    //     return head;
    ListNode currentNode = head;
    ListNode prevNode = null;
    while (currentNode != null) {
      ListNode nextNode = currentNode.next;
      currentNode.next = prevNode;
      prevNode = currentNode;
      currentNode = nextNode;
    }
    return prevNode;
  }
}
