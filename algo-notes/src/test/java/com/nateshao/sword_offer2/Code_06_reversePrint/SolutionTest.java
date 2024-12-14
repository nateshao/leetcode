package com.nateshao.sword_offer2.Code_06_reversePrint;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/9/18 9:14
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 用链表linkedList，如果链表不为null，添加链表的值到栈里面，
     * 将转转化为数组
     *
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

    /**
     * 递归，如果head==null，return
     * 递归下一个节点，如果将head.val存入Array里面
     *
     * @param head
     * @return
     */
    ArrayList<Integer> res = new ArrayList<Integer>();
    public int[] reversePrint2(ListNode head) {
        recur(head);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        res.add(head.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}