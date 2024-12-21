package com.nateshao.codetop;

public class Code10_longestPalindrome {
    /**
     * 5. 最长回文子串
     * https://leetcode.cn/problems/longest-palindromic-substring/
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 思路：寻找回文串的问题核心思想是：从中间开始向两边扩散来判断回文串，对于最长回文子串，就是这个意思：
     *
     * @param s
     * @return
     */
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

    public String palindrome(String s, int left, int right) {
        // 防止索引越界
        if (s == null || s.length() == 0) return "";
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // 向两边展开
            left--;
            right++;
        }
        // 返回以 s[left] 和 s[right] 为中心的最长回文串
        return s.substring(left + 1, right);
    }
}
