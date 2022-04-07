package com.nateshao.sword_offer2.Code_24_reverseList;

/**
 * @date Created by 邵桐杰 on 2022/3/8 9:08
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 限制：0 <= 节点个数 <= 5000
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
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        // if (head == null || head.next == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }
}
