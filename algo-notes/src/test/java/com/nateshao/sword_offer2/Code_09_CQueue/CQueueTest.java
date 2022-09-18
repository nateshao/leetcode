package com.nateshao.sword_offer2.Code_09_CQueue;


import java.util.LinkedList;

/**
 * @date Created by 邵桐杰 on 2022/3/30 16:23
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class CQueueTest {


    /**
     * 初始化两个链表
     * appendTail():将数字 val 加入栈 A 即可。
     * delete():
     *
     */
    private LinkedList<Integer> A,B;
    public CQueueTest() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    //

    /**
     * 入队
     * 栈A,负责入队
     * @param value
     */
    public void appendTail(int value) {
        A.addLast(value);
    }

    /**
     * 栈B，负责出队
     * 1. 当 A 为空： 即两个栈都为空，无元素，因此返回 −1 。
     * 2. 如果栈b不为空，移除栈b的最后一个元素
     * 3. 当栈A不为空，栈 A 元素全部转移至栈 B 中，实现元素倒序，并返回栈 B 的栈顶元素。
     * @return
     */
    public int delete() {
        if (!B.isEmpty())return B.removeLast();
        if (A.isEmpty())return -1;
        while (!A.isEmpty())B.addLast(B.removeLast());
        return B.removeLast();
    }

    /**
     * 栈A: 1 2 3
     * 栈B: 3 2 1
     *
     * 队列：1 2 3
     */
}