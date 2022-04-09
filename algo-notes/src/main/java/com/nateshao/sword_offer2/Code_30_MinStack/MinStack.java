package com.nateshao.sword_offer2.Code_30_MinStack;


import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/3/21 11:37
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *
 */
public class MinStack {
    private Stack<Integer> stack1; // 数据栈
    private Stack<Integer> stack2; // 辅助栈，记录每次有元素进栈后或者出栈后，元素的最小值

    public MinStack() {
        // 初始化辅助栈和数据栈
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        // 数据栈，进栈
        stack1.push(x);
        // 如果记录当前数据栈中最小值的辅助栈为空，或者最小值小于 x，则将 x 设置为最小值，即进辅助栈
        if (stack2.isEmpty() || stack2.peek() >= x) stack2.push(x);
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())) stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
