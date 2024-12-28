package com.nateshao.codetop;

public class Code5_reverseKGroup {
    /**
     * 25. K 个一组翻转链表
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
     * <p>
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转区间 [a, b) 的元素，注意是左闭右开
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null;
        cur = a;
        nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

    /**
     * https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/10416/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                if (end.next == null) break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse2(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse2(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
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
