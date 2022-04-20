package com.nateshao.hot100.include;

import java.util.List;

/**
 * Definition for a singly-linked list node
 */
public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    /**
     * Generate a linked list with an array
     * @param arr
     * @return
     */
    public static ListNode arrToLinkedList(int[] arr) {
        ListNode dum = new ListNode(0);
        ListNode head = dum;
        for (int val : arr) {
            head.next = new ListNode(val);
            head = head.next;
        }
        return dum.next;
    }

    /**
     * Get a list node with specific value from a linked list
     * @param head
     * @param val
     * @return
     */
    public static ListNode getListNode(ListNode head, int val) {
        while (head != null && head.val != val) {
            head = head.next;
        }
        return head;
    }
}
