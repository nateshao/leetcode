package com.nateshao.leetcode_cn;

import java.util.List;

public class Code2_add_two_numbers {
    public static void main(String[] args) {

    }

    /**
     * 2. 两数相加 https://leetcode.cn/problems/add-two-numbers/description/
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * @param l1
     * @param l2
     * @return
     */
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode p1 = l1, p2 = l2;
//        // 虚拟头节点
//        ListNode dummy = new ListNode(-1);
//        // 指针p负责构建新链表
//        ListNode p = dummy;
//        int carry = 0; // 记录进位
//        while (p1 != null || p2 != null) {
//            int sum = carry;
//            if (p1 != null) {
//                sum += p1.val;
//                p1 = p1.next;
//            }
//            if (p2 != null) {
//                sum += p2.val;
//                p2 = p2.next;
//            }
//            carry = sum / 10;
//            sum %= 10;
//            p.next = new ListNode(sum);
//            p = p.next;
//        }
//        return dummy.next;
//    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 在两条链表上的指针
        ListNode p1 = l1, p2 = l2;
        // 虚拟头结点（构建新链表时的常用技巧）
        ListNode dummy = new ListNode(-1);
        // 指针 p 负责构建新链表
        ListNode p = dummy;
        // 记录进位
        int carry = 0;
        // 开始执行加法，两条链表走完且没有进位时才能结束循环
        while (p1 != null || p2 != null || carry > 0) {
            // 先加上上次的进位
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            // 处理进位情况
            carry = val / 10;
            val = val % 10;
            // 构建新节点
            p.next = new ListNode(val);
            p = p.next;
        }
        // 返回结果链表的头结点（去除虚拟头结点）
        return dummy.next;
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
