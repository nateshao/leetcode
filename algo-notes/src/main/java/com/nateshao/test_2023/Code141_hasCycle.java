package com.nateshao.test_2023;


import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2023/1/8 15:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 */
public class Code141_hasCycle {
    public static void main(String[] args) {


    }

    /**
     * 链表是否有环
     * 相当于数组里面有没有重复数字
     * 有重复数字就返回true，没有就返回false
     * 方法一：hashset
     * 用hashset，当head！=null
     * if（res.contain(head)）return true
     * head = head.next
     *
     * @return
     */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> res = new HashSet<>();
        while (head != null) {
            if (res.contains(head)) return true;
            res.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针
     * 定义快慢指针
     * while（fast！=null && fast.next!=null）
     * 比较快指针和慢指针是否相等
     * 快指针走两步，慢指针走一步
     * <p>
     * 否则返回false
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head, slow = head;
        if (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
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
