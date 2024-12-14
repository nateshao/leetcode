package com.nateshao.leetcode.code09_isPalindrome;

/**
 * @date Created by 邵桐杰 on 2022/9/27 16:44
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {

//    public boolean isPalindrome2(int x) {
//
//    }

    public boolean isPalindrome(int x) {
        StringBuilder ss = new StringBuilder();
        String a = x + "";
        char[] chars = a.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            ss.append(chars[i]);
        }
        if (a.equals(ss.toString())) {
            return true;
        }
        return false;
    }
}
