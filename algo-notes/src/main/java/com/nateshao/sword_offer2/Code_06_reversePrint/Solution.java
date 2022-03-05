package com.nateshao.sword_offer2.Code_06_reversePrint;


import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/3/5 21:43
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Solution {

    /**
     * 入栈： 遍历链表，将各节点值 push 入栈。（Python​ 使用 append() 方法，​Java​借助 LinkedList 的addLast()方法）。
     * 出栈： 将各节点值 pop 出栈，存储于数组并返回。（Python​ 直接返回 stack 的倒序列表，
     * Java ​新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出）。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/solution/mian-shi-ti-06-cong-wei-dao-tou-da-yin-lian-biao-d/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {

        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
