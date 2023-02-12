package com.nateshao.test_2023;

/**
 * @date Created by 邵桐杰 on 2023/2/5 1:13
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 19. 删除链表的倒数第 N 个结点
 */
public class Code19_removeNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 定义快慢指针
        ListNode fast = pre, slow = pre;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {
        // 定义一个伪节点，用于返回结果
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // 定义一个快慢指针, 指向伪节点，用于遍历链表
        ListNode fast = pre, slow = pre;
        // 让快指针先移动 n 步
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        // 只要快指针不指向空，就继续循环
        while (fast.next != null) {
            // 让快慢指针同时移动
            slow = slow.next;
            fast = fast.next;
        }
        // 这时慢指针移动到的位置就是，要删除节点的前一个节点
        // 所以只要删除当前节点的下一个节点
        slow.next = slow.next.next;
        // 返回为指针指向的头节点
        return pre.next;
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


    /**
     * 双指针
     * 定义虚拟头节点pre，
     * pre.next=head
     * 定义快慢指针
     * 快指针先走n步
     * fast.next!=null,快慢指针一起走，
     * 删除节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode fast = res, slow = res;
//        for (int i = 0; i < n; i++) {
//            fast = fast.next;
//        }
        while (n>0){
            fast=fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return res.next;
    }
}
