package com.nateshao.codetop;

/**
 * @date Created by 邵桐杰 on 2022/8/11 23:30
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Code3_reverseList {
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
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }

    public ListNode restoreList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     * @date 2024-12-28 10:28
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public ListNode reverseList5(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList5(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public ListNode reverseList6(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseList6(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    public ListNode reverseList7(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseList7(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList8(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head, pre = null;
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
