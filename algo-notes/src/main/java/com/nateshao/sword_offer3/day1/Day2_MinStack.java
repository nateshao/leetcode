package com.nateshao.sword_offer3.day1;


import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/5/26 9:29
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min
 * 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class Day2_MinStack {
    // 初始化两个栈A,B
    Stack<Integer> A, B;

    /**
     * initialize your data structure here.
     */
    public Day2_MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    /**
     * push(x) 函数： 重点为保持栈 B 的元素是 非严格降序 的。
     * <p>
     * 将 x 压入栈 A （即 A.add(x) ）；
     * 若 ① 栈 B 为空 或 ② x 小于等于 栈 B 的栈顶元素，则将 x 压入栈 B （即 B.add(x) ）。
     *
     * @param x
     */
    public void push(int x) {
        A.add(x);
        if (B.isEmpty() || x <= B.peek()) {
            B.add(x);
        }
    }

    /**
     * pop() 函数： 重点为保持栈 A, B 的 元素一致性 。
     * <p>
     * 执行栈 A 出栈（即 A.pop() ），将出栈元素记为 y ；
     * 若 y 等于栈 B 的栈顶元素，则执行栈 B 出栈（即 B.pop() ）。
     */
    public void pop() {
        if (A.pop().equals(B.peek()))B.pop();
    }

    /**
     * top() 函数： 直接返回栈 A 的栈顶元素即可，即返回 A.peek() 。
     *
     * @return
     */
    public int top() {
        return A.peek();
    }

    /**
     * min() 函数： 直接返回栈 B 的栈顶元素即可，即返回 B.peek() 。
     *
     * @return
     */

    public int min() {
        return B.peek();
    }
}
