package com.nateshao.sword_offer3.day1;

import java.util.LinkedList;

/**栈与队列（简单）
 * @date Created by 邵桐杰 on 2022/5/25 22:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 09. 用两个栈实现队列
 * 思路：
 * 初始化：两个链表A,B
 *
 */
public class Day1_CQueue {
    LinkedList<Integer> A, B;

    public Day1_CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    /**
     * 删除元素
     * 如果B不为空，删除B的最后一个元素
     * 如果A为空，返回-1
     * 如果A不为空，B添加最后的元素，（A移除最后一个元素）
     * 然会B的最后一个元素
     *
     * @return
     */
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
