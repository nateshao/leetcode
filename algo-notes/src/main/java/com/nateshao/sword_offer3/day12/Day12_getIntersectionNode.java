package com.nateshao.sword_offer3.day12;

/**
 * @date Created by 邵桐杰 on 2022/7/13 10:56
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * 如下面的两个链表：
 * 在节点 c1 开始相交。
 * 示例 1：
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class Day12_getIntersectionNode {
    /**
     * 双指针
     * 我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
     * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
     * 当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
     * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        // 初始化双指针
        ListNode node1 = headA, node2 = headB;
        while (node1 != node2) {
            node1 = node1 == null ? headB : node1.next; // 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
            node2 = node2 == null ? headA : node2.next; // 当 node2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
        }
        return node1;
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
