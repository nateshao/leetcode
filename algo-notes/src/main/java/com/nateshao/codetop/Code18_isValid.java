package com.nateshao.codetop;

import org.checkerframework.checker.units.qual.C;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Code18_isValid {
    /**
     * 20. 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     * https://leetcode.cn/problems/valid-parentheses/description/
     *
     * <p>
     * 思路：栈  栈是最标准的解法，大家不要争了
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char target = stack.pop();
                if (c == ')' && target != '(') return false;
                if (c == '}' && target != '{') return false;
                if (c == ']' && target != '[') return false;
            }
        }
        return stack.isEmpty();
    }


    /**
     * 法二：有效的括号（辅助栈法，极简+图解）
     */

//    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
//        put('{','}'); put('[',']'); put('(',')'); put('?','?');
//    }};
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public boolean isValid2(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            } else if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }
        return stack.size() == 1;
    }

}
