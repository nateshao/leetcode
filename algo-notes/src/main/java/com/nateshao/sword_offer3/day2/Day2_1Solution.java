package com.nateshao.sword_offer3.day2;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/5/26 9:55
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Day2_1Solution {
    public static void main(String[] args) {
    }

    ArrayList<Integer> tmp = new ArrayList<Integer>();

    /**
     * 法一：递归
     * 递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
     * 回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
     * 最终，将列表 tmp 转化为数组 res ，并返回即可。
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp.get(i);
        }
        return res;
    }

    /**
     * 方法二：辅助栈法
     * 入栈： 遍历链表，将各节点值 push 入栈。​Java​借助 LinkedList 的addLast()方法。
     * 出栈： 将各节点值 pop 出栈，存储于数组并返回。Java 新建一个数组，通过 popLast() 方法将各元素存入数组，实现倒序输出。
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head.val); // 存入栈
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            stack.removeLast();// 取出
        }
        return res;

    }

    public void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
