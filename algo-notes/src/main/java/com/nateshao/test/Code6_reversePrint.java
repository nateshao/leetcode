package com.nateshao.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/5/29 9:58
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Code6_reversePrint {
    /**
     * 辅助栈法
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
//        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
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
