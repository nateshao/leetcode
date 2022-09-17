package com.nateshao.hot100.code_two_pointers.code2_125_isPalindrome;

/**
 * @date Created by 邵桐杰 on 2022/9/16 23:53
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: https://leetcode.cn/problems/valid-palindrome/
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 */
public class Main {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int n = s.length();
        StringBuilder sb = new StringBuilder(n);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());

    }


}
