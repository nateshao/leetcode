package com.nateshao.hot100.code_two_pointers.code1_19_removeNthFromEnd;


/**
 * @date Created by 邵桐杰 on 2022/9/16 10:20
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class SolutionTest {
//    public ListNode removeNthFromEnd(Solution.ListNode head, int n) {
//        ListNode pre = new ListNode(-1);
//        pre.next = head;
//        ListNode slow = pre, fast = pre;
//        while (n > 0) {
//            fast = fast.next;
//            n--;
//        }
//        while (fast!=null){
//            fast= fast.next;
//            slow = slow.next;
//        }
//        slow.next=slow.next.next;
//        return pre.next;
//
//    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, Solution.ListNode next) {
            val = val;
            next = next;
        }
    }
}