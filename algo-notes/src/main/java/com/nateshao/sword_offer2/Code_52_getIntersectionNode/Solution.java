package com.nateshao.sword_offer2.Code_52_getIntersectionNode;

/**
 * @date Created by 邵桐杰 on 2022/10/2 18:15
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Solution {
    /**
     * 双指针
     * 初始化双指针
     * 当headA != headB
     * 当A != null，走A.next，否则就切换到headB
     * 当B != null，走B.next，否则就切换到headA
     * 最后返回A
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
