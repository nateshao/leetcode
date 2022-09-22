package com.nateshao.sword_offer2.Code_18_deleteNode;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 12:29
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 递归实现
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
     * 双指针
     * 特例处理： 当应删除头节点 head 时，直接返回 head.next 即可。
     * 初始化： pre = head , cur = head.next 。
     * 定位节点： 当 cur 为空 或 cur 节点值等于 val 时跳出。
     * 保存当前节点索引，即 pre = cur 。
     * 遍历下一节点，即 cur = cur.next 。
     * 删除节点： 若 cur 指向某节点，则执行 pre.next = cur.next ；若 cur 指向 null ，代表链表中不包含值为 val 的节点。
     * 返回值： 返回链表头部节点 head 即可。
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode pre = head, cur = head;
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