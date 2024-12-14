package com.nateshao.sword_offer2.Code_31_validateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/20 23:29
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class SolutionTest {
    /**
     * 初始化： 辅助栈 stack ，弹出序列的索引 i ；
     * 遍历压栈序列： 各元素记为 num ；
     * 元素 num 入栈；
     * 循环出栈：若 stack 的栈顶元素 == 弹出序列元素 popped[i]，则执行出栈与 i++；
     * 返回值： 若 stack 为空，则此弹出序列合法。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty(); // 如果栈都为空了，说明true。
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0; //索引popped
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}