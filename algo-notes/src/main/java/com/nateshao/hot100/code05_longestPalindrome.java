package com.nateshao.hot100;

/**
 * @date Created by 邵桐杰 on 2022/8/13 23:24
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 5. 最长回文子串
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
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
public class code05_longestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome4(s);
        System.out.println("res = " + res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        int strLen = s.length();
        int maxStart = 0; //最长回文串的起点
        int maxEnd = 0;   //最长回文串的终点
        int maxlen = 1;   //最长回文串的长度
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxlen) {
                        maxlen = r - l + 1;
                        maxStart = 1;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }


    /**
     * 双指针
     * 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串，对于最长回文子串，就是这个意思：
     * 找回文串的关键技巧是传入两个指针 l 和 r 向两边扩散，因为这样实现可以同时处理回文串长度为奇数和偶数的情况。
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
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

    String palindrome(String s, int l, int r) {
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

    /**
     * 双指针
     * 定义左右指针，两个指针由两边向中间走
     * (l>0 && l<r && s.charAt(l) == s.charAt(r))
     * l++
     * r--
     * 截取res
     *
     * @param s
     * @return
     */
    public static String longestPalindrome4(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = reverse(s, i, i);
            String s2 = reverse(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    static String reverse(String s, int l, int r) {

        if (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }







}
