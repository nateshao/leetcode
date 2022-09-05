package com.nateshao.hot100.code_two_pointers.code_234_isPalindrome;


import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/9/5 16:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/palindrome-linked-list/
 * 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：head = [1,2]
 * 输出：false
 */
public class Solution {
    /**
     * 这道题的关键在于，单链表无法倒着遍历，无法使用双指针技巧。
     *
     * 那么最简单的办法就是，把原始链表反转存入一条新的链表，然后比较这两条链表是否相同。
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    /**
     * 先循环一遍，将值保存到栈中，再次循环列表与出栈的值比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        // 暴力解法 保存值 重新循环查看是否一致
        ListNode node = head;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        // 利用栈的特性
        while (head != null) {
            if (head.val != stack.pop()) return false;
            head = head.next;
        }
        return true; // 循环走到这里，说明都匹配
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
