package com.nateshao.day03_Stacks_and_Queues.demo01_Linked_List_Problems_in_Leetcode;

/**
 * @date Created by 邵桐杰 on 2021/9/9 18:13
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution3 {
    public ListNode removeList(ListNode head,int val){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }
}
