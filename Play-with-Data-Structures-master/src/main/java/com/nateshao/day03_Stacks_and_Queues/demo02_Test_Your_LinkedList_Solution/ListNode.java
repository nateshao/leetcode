package com.nateshao.day03_Stacks_and_Queues.demo02_Test_Your_LinkedList_Solution;

import java.util.LinkedHashMap;

/**
 * @date Created by 邵桐杰 on 2021/9/9 18:22
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: Definition for singly-linked list.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be null");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

    }
    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        if (cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;

        }
        s.append("NULL");
        return s.toString();
    }
}
