package com.nateshao.sword_offer2.Code_18_deleteNode;

/**
 * @date Created by 邵桐杰 on 2022/4/6 9:38
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 *
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class Solution {
    /**
     * 解法一：递归
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        head.next = deleteNode(head.next, val);
        return head;
    }

    /**
     * 解法二，双指针
     *
     * 特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
     * 初始化： pre = head , cur = head.next 。
     * 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
     * 保存当前节点索引，即 pre = cur 。
     * 遍历下一节点，即 cur = cur.next 。
     * 删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next ；若 cur 指向 null ，代表链表中不包含值为 val 的节点。
     * 返回值： 返回链表头部节点 head 即可。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) pre.next = cur.next;
        return head;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
