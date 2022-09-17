package com.nateshao.sword_offer.topic_23_MinStack;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/28 21:38
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 包含min函数的栈
 * 思路：定义两个栈，一个存放入的值。另一个存最小值。
 */
public class MinStack {
    private Stack<Integer> stack1; // 数据栈
    private Stack<Integer> stack2; // 辅助栈，记录每次有元素进栈后或者出栈后，元素的最小值

    /**
     * initialize your data structure here.
     */
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

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

    /**
     * 精选解答
     */
    class MinStack1 {

        Stack<Integer> A, B;

        public MinStack1() {
            A = new Stack<>();
            B = new Stack<>();
        }

        public void push(int x) {
            A.add(x);
            if (B.empty() || B.peek() >= x)
                B.add(x);
        }

        public void pop() {
            if (A.pop().equals(B.peek()))
                B.pop();
        }

        public int top() {
            return A.peek();
        }

        public int min() {
            return B.peek();
        }

    }

}
