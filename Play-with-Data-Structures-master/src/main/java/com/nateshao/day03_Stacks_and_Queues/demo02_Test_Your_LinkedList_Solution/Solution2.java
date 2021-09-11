package com.nateshao.day03_Stacks_and_Queues.demo02_Test_Your_LinkedList_Solution;

/**
 * @date Created by 邵桐杰 on 2021/9/10 22:49
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: Leetcode 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        if (head == null)
            return head;

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }
}
