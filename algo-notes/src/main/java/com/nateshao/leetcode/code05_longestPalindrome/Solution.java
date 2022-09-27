package com.nateshao.leetcode.code05_longestPalindrome;

/**
 * @date Created by 邵桐杰 on 2022/9/27 16:28
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 */
public class Solution {
    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome(s);
        System.out.println("res = " + res);

    }

    /**
     * 5. 最长回文子串
     * 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串，对于最长回文子串，就是这个意思：
     * 找回文串的关键技巧是传入两个指针 l 和 r 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。
     * <p>
     * Copy
     * for 0 <= i < len(s):
     * # 找到以 s[i] 为中心的回文串
     * palindrome(s, i, i)
     * # 找到以 s[i] 和 s[i+1] 为中心的回文串
     * palindrome(s, i, i + 1)
     * 更新答案
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
}
