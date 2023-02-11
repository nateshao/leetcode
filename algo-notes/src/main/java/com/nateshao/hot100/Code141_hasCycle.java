package com.nateshao.hot100;

import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2023/2/11 20:50
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code141_hasCycle {
    /**
     * hashset
     *
     * @param head
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
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
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
