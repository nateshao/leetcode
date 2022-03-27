package com.nateshao.zijie_code_66;

/**
 * @date Created by 邵桐杰 on 2022/3/26 11:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/reorder-list/
 * 143. 重排链表
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class Day19_reorderList {
    public void reorderList(ListNode head) {
        //快慢指针找中间节点
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转后半段链表
        ListNode p = slow.next;
        //后半段链表头节点
        ListNode head2 = null;
        slow.next = null;
        while(p != null) {
            ListNode q = p.next;
            p.next = head2;
            head2 = p;
            p = q;
        }
        //合并前后两段链表
        ListNode i = head, j = head2;
        while(i != null && j != null) {
            ListNode t1 = i.next, t2 = j.next;
            i.next = j;
            j.next = t1;
            i = t1;
            j = t2;
        }
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
