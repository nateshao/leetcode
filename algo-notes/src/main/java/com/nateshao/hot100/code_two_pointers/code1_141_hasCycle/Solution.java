package com.nateshao.hot100.code_two_pointers.code1_141_hasCycle;

import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/9/5 15:07
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/linked-list-cycle/
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * <p>
 * 注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * <p>
 * <p>
 * 我的理解，相当一个数组，里面有没有重复数字，有就返回true，没有就false
 */
public class Solution {
    /**
     * 定义快慢指针
     * 快指针走2步，慢指针走1步，如果快指针==慢指针，说明快指针走了一圈
     * 说明有环，否则则无环。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 定义快慢指针
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public boolean isCircleByTwoPoint(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { // 注意这个条件，要防止空指针
            fast = fast.next.next; // 快指针走一步。
            slow = slow.next; // 慢指针走两步。
            if (fast == slow) return true;
        }
        return false;
    }

    /**
     * 前提：不限制空间复杂度
     * 思路：遍历链表，判断当前节点是否在哈希表中，如果存在，就说明当前链表有环
     * 如果不存在，那么我们将当前链表的节点存入哈希表中，并继续往后遍历，直到发生哈希碰撞。
     * 如果存在环，那么就一定会发生哈希碰撞，如果不存在环，那么就一定有一个节点的next指针指向null，此时循环停止。
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        HashSet<ListNode> res = new HashSet<>();
        while (head != null) {
            if (res.contains(head)) return true;
            res.add(head);
            head = head.next;
        }
        return false;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
