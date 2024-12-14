package com.nateshao.hot100;


/**
 * 5. 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串，对于最长回文子串，就是这个意思
 */
public class Code5_longestPalindrome {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            longest = longest.length() > s1.length() ? longest : s1;
            longest = longest.length() > s2.length() ? longest : s2;
        }
        return longest;
    }

    String palindrome(String s, int left, int right) {
        // 防止索引越界
        if (s == null || s.length() == 0) return "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 向两边展开
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left, right + 1);
    }

}
