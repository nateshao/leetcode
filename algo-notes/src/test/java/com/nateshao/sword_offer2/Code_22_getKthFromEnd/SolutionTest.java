package com.nateshao.sword_offer2.Code_22_getKthFromEnd;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 15:57
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) { // 快指针先走k步
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}