package com.nateshao.leetcode_cn;

public class Code5_longestPalindrome {
    /**
     * 5. 最长回文子串
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 思路：从中间向两边展开，要考虑奇数、偶数
     * https://leetcode.cn/problems/longest-palindromic-substring/
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
