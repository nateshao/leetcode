package com.nateshao.sword_offer.topic_07_CQueue;

import java.util.Stack;


/**
 * @date Created by 邵桐杰 on 2021/11/18 16:25
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 两个栈实现队列
 */
public class CQueueTest {
    // 初始化两个栈，一个入栈，一个出栈。
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public CQueueTest() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }


}