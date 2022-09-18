package com.nateshao.sword_offer2.Code_09_CQueue;

import org.checkerframework.checker.units.qual.C;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/9/18 13:10
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class CQueue {
    // 初始化两个栈AB
     LinkedList<Integer> A, B;

    // 实例化构造两个栈
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    // 队列的添加操作
    public void appendTail(int value) {
        A.add(value);
    }

    /** 队列的删除操作
     * 1. 当栈A为空，则两个栈都没数据，返回-1
     * 2. 当栈B不为空，
     *
     * @return
     */
    public int deleteHead() {
        if (!B.isEmpty()) return B.removeLast();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()) B.addLast(A.removeLast());
        return B.removeLast();
    }

}
