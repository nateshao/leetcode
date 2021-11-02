package com.nateshao.play_with_data_structures.lesson_02_stacks_and_queues.stack_leetcode;

import java.util.Stack;

/**
 * @date Created by 邵桐杰 on 2021/11/2 12:20
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode-cn.com/problems/valid-parentheses/
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {
    public static void main(String[] args) {

        System.out.println(isValid("[({})]"));
        System.out.println(isValid("[})}{})]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char topChar = stack.pop();
                if (c == '}' && topChar != '{')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == ')' && topChar != '(')
                    return false;
            }

        }
        return stack.isEmpty();
    }


}
