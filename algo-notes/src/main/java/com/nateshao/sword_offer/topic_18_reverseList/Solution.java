package com.nateshao.sword_offer.topic_18_reverseList;

/**
 * @date Created by 邵桐杰 on 2021/11/22 19:41
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 反转链表
 * 思路：定义两个指针，反向输出
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 */
public class Solution {

    /**
     * 解法一：迭代：两个指针，反向输出，时间复杂度：O(n)，空间复杂度：O(1)
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
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


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
