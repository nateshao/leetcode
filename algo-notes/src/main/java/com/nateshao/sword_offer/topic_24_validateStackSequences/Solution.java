package com.nateshao.sword_offer.topic_24_validateStackSequences;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/28 21:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 */
public class Solution {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        int[] popped1 = {4, 3, 5, 1, 2};
        boolean b = validateStackSequences1(pushed, popped);
        System.out.println("b = " + b);// b = true
        boolean b1 = validateStackSequences2(pushed, popped1);
        System.out.println("b1 = " + b1);
    }

    /**
     * 精选解答
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences1(int[] pushed, int[] popped) {
        if (pushed == null || pushed == null) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 思路：用栈来压入弹出元素，相等则出栈。
     *
     * @param pushed
     * @param popped
     * @return
     */
    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;
        Stack<Integer> stack = new Stack<>();// 借用一个辅助栈stack
        int index = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);// 入栈
            //循环判断 栈不为空 && 栈顶元素 == 弹出序列的当前元素
            while (!stack.isEmpty() && stack.peek().equals(popped[index])) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
//        return index==popped.length;
    }
}