package com.nateshao.hot100;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/8/14 11:51
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class code05_longestPalindromeTest {
    /**
     * 最长回文字符串
     * 思路：
     * 从中心向两边散开
     * 定义两个双指针，向两边扩散，处理回文长度奇数和偶数的情况
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以s[i]为中心的最长回文字符串
            String s1 = palindrome(s, i, i);
            // 以s[i]和s[i+1]为中心的最长回文字符串
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 防止索引出界
     * 向两边展开
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            right++;
            left--;
        }
        // 返回s[left] 和 s[right]
        return s.substring(left + 1, right);
    }

}