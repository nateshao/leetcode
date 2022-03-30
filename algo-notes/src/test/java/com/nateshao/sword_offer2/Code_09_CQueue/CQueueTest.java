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
    private LinkedList<Integer> A;
    private LinkedList<Integer> B;

    public CQueueTest() {
        A = new LinkedList<Integer>();
        A = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int delete() {
        if (!B.isEmpty())return B.removeLast();
        if (A.isEmpty())return -1;
        while (!A.isEmpty())B.addLast(B.removeLast());
        return B.removeLast();
    }
}