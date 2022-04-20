package com.nateshao.hot100.code02_addTwoNumbers;

import com.nateshao.hot100.include.ListNode;

/**
 * @date Created by 邵桐杰 on 2022/4/20 11:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    /**
     * 1，按位求和
     * 2，进位
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2; // 在两条链表上的指针
        ListNode dummy = new ListNode(-1); // 虚拟头结点（构建新链表时的常用技巧）
        ListNode p = dummy;// 指针 p 负责构建新链表
        int carry = 0;// 记录进位
        while (p1 != null || p2 != null || carry > 0) {// 开始执行加法，两条链表走完且没有进位时才能结束循环
            int val = carry;// 先加上上次的进位
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

        return dummy.next;// 返回结果链表的头结点（去除虚拟头结点）
    }

//    public class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode() {
//        }
//
//        ListNode(int val) {
//            this.val = val;
//        }
//
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
}

