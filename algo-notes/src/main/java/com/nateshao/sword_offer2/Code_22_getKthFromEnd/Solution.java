package com.nateshao.sword_offer2.Code_22_getKthFromEnd;

/**
 * @date Created by 邵桐杰 on 2022/3/8 8:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 双指针
     * 初始化： 前指针 fast 、后指针 slow ，双指针都指向头节点 head​ 。
     * 构建双指针距离：前指针 fast 先向前走 k 步（结束后，双指针 fast 和 slow 间相距 k 步）。
     * 双指针共同移动：循环中，双指针 fast 和 slow 每轮都向前走一步，直至 fast 走过链表 尾节点 时跳出（跳出后， slow 与尾节点距离为 k−1，即 slow 指向倒数第 k 个节点）。
     * 返回值： 返回 slow 即可。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (k > 1) {
            if (fast.next == null) return null;// 说明快指针走完了
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k < 1) return null;
        // 定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (k > 1) {
            if (fast.next == null) return null;
            fast = fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
