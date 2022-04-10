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
 * 思路：本题难点： 将 min() 函数复杂度降为 O(1) ，可通过建立辅助栈实现；
 * 1. 数据栈 A ： 栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
 * 2. 辅助栈 B ： 栈 B 中存储栈 A 中所有 非严格降序 的元素，则栈 A 中的最小元素始终对应栈 B 的栈顶元素，即 min() 函数只需返回栈 B 的栈顶元素即可。
 * 因此，只需设法维护好 栈 B 的元素，使其保持非严格降序，即可实现 min() 函数的 O(1)O(1) 复杂度。
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
        // 辅助栈stack2为空，且栈顶元素大于进栈元素x，将x压栈
        if (stack2.isEmpty() || stack2.peek() >= x) stack2.push(x);// stack2存最小值
    }

    public void pop() { // 出栈
        // 如果数据栈出栈元素==辅助栈的栈顶元素，数据栈stack2出栈
        if (stack1.pop().equals(stack2.peek())) stack2.pop();
    }

    public int top() {
        return stack1.peek();// 返回栈顶的元素但不移除它。Stack的pop方法是会移除的。
    }

    public int min() {
        return stack2.peek();// 返回
    }
}
