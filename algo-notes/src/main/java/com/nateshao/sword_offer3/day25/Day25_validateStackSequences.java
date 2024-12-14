package com.nateshao.sword_offer3.day25;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/7/24 11:02
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Day25_validateStackSequences {
    /**
     * 比较入栈与出栈的值是否相等
     * 初始化： 辅助栈 stack ，弹出序列的索引 index ；
     * 遍历压栈序列： 各元素记为 num ；
     * 元素 num 入栈；
     * 循环出栈：若 stack 的栈顶元素 = 弹出序列元素 popped[i]，则执行出栈与 i++；
     * 返回值： 若 stack为空，则此弹出序列合法。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num); // 入栈
            while (!stack.isEmpty() && stack.peek() == popped[index]) { // 循环判断与出栈
                stack.pop(); // 出栈
                index++;
            }
        }
        return stack.isEmpty();
    }
}
