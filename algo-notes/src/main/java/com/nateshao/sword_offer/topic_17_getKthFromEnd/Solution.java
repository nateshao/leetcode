package com.nateshao.sword_offer.topic_17_getKthFromEnd;

/**
 * @date Created by 邵桐杰 on 2021/11/22 15:28
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer  链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class Solution {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) return null; // head为空指针 or 输入的参数k为0； 鲁棒性也是很重要的~

        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            if (former == null && k > i) return null; // k大于链表的长度；
            former = former.next;
        }
        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;

    }

    /**
     * 思路：
     * 定义一快一慢两个指针，快指针走 K 步，然后慢指针开始走，当快指针和慢指针相差k步时。快慢指针一起走。
     * 当快指针到尾时，慢指针就找到了倒数第 K个节点。
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 为链表的长度。我们使用快慢指针，只需要一次遍历即可，复杂度为 O(n)。
     * 空间复杂度：O(1)。
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;
        ListNode fast = head;
        ListNode slow = head;
        while (k-- > 1) {// 先比较再判断
            if (fast.next == null) return null;
            fast = fast.next;
//            k--;
        }
        while (fast.next != null) {
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
