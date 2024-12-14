package com.nateshao.sword_offer.topic_05_reversePrint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/16 23:12
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 剑指 Offer 05. 从尾到头打印链表
 * > 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * >
 * > 示例 1：
 * > 输入：head = [1,3,2]
 * > 输出：[2,3,1]
 * > 限制：0 <= 链表长度 <= 10000
 */
public class Solution {

    /**
     * 方法一：辅助栈法
     * <p>
     * 算法流程：
     * 入栈： 遍历链表，将各节点值 push 入栈。（Java​借助 LinkedList 的addLast()方法）。
     * 出栈： 将各节点值 pop 出栈，存储于数组并返回。（Java新建一个数组，通过 popLast()方法将各元素存入数组，实现倒序输出）。
     * 复杂度分析：
     * 时间复杂度 O(N)：入栈和出栈共使用 O(N) 时间。
     * 空间复杂度 O(N)：辅助栈 stack 和数组 res 共使用 O(N)的额外空间。
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) { // 官方题解
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public static ArrayList<Integer> reversePrint2(ListNode head) {
        Stack<Integer> stack = new Stack();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }



    /**
     * 法二：递归法 1
     * 1.递推阶段： 每次传入 head.next，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
     * 2.回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
     * 3.最终，将列表 tmp 转化为数组 res，并返回即可。
     * @param head
     * @return
     */
    ArrayList<Integer> tmp = new ArrayList<Integer>();
    public int[] reversePrint3(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }
    void recur(ListNode head) {
        if(head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    /**
     *  法二：递归法 2
     * @param headNode
     * @return
     */
    public static ArrayList<Integer> reversePrint4(ListNode headNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (headNode != null) {
            if (headNode.next != null) {
                list = reversePrint4(headNode.next);
            }
            list.add(headNode.val);
        }
        return list;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
