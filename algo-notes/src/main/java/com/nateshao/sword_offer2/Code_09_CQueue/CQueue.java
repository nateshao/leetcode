package com.nateshao.sword_offer2.Code_09_CQueue;


import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/3/5 22:04
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * <p>
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead .
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * 输出：[null,-1,null,null,5,2]
 * [[],[],[5],[2],[],[]]
 */
public class CQueue {

    /**
     * 思路：
     * 加入队尾 appendTail()函数： 将数字 val 加入栈 A 即可。
     * 删除队首deleteHead()函数： 有以下三种情况。
     * 当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
     * 否则，当 A 为空： 即两个栈都为空，无元素，因此返回 −1 。
     * 否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
     */
    /**
     * 初始化两个链表，
     * // 栈 B 元素实现栈 A 元素倒序 ,然后通过B.removeLast()将元素移出去
     * // 栈A作为辅助元素
     */
    LinkedList<Integer> A, B;// 栈A支持插入操作，栈B支持删除操作


    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    /**
     * 添加
     *
     * @param value
     */
    public void appendTail(int value) {
        A.addLast(value);
    }

    /**
     * 删除
     *
     * @return
     */
    public int delete() {
        // 当栈 B 不为空： B中仍有已完成倒序的元素，因此直接返回 B 的栈顶元素。
        if (!B.isEmpty()) return B.removeLast();
        // 否则，当 A 为空： 即两个栈都为空，无元素，因此返回 −1 。
        if (A.isEmpty()) return -1;
        // 否则： 将栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
        while (!A.isEmpty()) B.addLast(B.removeLast());
        return B.removeLast();
    }


}
