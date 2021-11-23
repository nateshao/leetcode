package com.nateshao.sword_offer.topic_19_mergeTwoLists;

/**
 * @date Created by 邵桐杰 on 2021/11/23 19:19
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 合并两个链表
 */
class Solution {

    /**
     * 方法一：递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return null;
        if (l2 == null) return null;
        if (l1 == l2) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

    /**
     *  精选解答：递归
     * 复杂度分析：
     * 时间复杂度 O(M+N)：M, N分别为链表l1和l2
     * 空间复杂度 O(1) ：节点引用 dum, cur使用常数大小的额外空间。
     * @param l1
     * @param l2
     * @return
     * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/solution/mian-shi-ti-25-he-bing-liang-ge-pai-xu-de-lian-b-2
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
