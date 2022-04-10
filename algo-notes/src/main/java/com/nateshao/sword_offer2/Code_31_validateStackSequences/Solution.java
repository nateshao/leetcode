package com.nateshao.sword_offer2.Code_31_validateStackSequences;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2022/4/10 9:30
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 */
public class Solution {
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
        Stack<Integer> stack = new Stack<>();// 初始化： 辅助栈 stack ，弹出序列的索引 i ；
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            if (!stack.isEmpty() && stack.peek() == popped[i]) {// 比较返回栈顶元素与出栈元素比较是否相等。
                stack.pop();// 相等就出栈
                i++;
            }
        }
        return stack.isEmpty();//如果栈都为空了，说明true。
    }

    /**
     * 判断合不合法，用个栈试一试:
     * 把压栈的元素按顺序压入，当栈顶元素和出栈的第一个元素相同，则将该元素弹出，出栈列表指针后移并继续判断。
     * 最后判断出栈列表指针是否指向出栈列表的末尾即可。
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque();
        int j = 0;
        for (int elem : pushed) {
            stack.push(elem);
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
