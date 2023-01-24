package com.nateshao.hot100.code05;

/**
 * @date Created by 邵桐杰 on 2022/10/7 21:36
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        String s = "babad";
        String res = longestPalindrome1(s);
        System.out.println("res = " + res);
    }

    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public static String longestPalindrome1(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }


//    public String longestPalindrome(String s) {
//        String res = "";
//        for (int i = 0; i < s.length(); i++) {
//            String s1 = palindrome(s, i, i);
//            String s2 = palindrome(s, i, i + 1);
//            res = res.length() > s1.length() ? res : s1;
//            res = res.length() > s2.length() ? res : s2;
//        }
//
//        return res;
//    }
//
//    String palindrome(String s, int left, int right) {
//        while (left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
//            left--;
//            right++;
//        }
//        return s.substring(left + 1, right);
//    }


    /**
     * 5. 最长回文子串
     * BAB
     * BAAB
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        // 遍历
        for (int i = 0; i < s.length(); i++) {
            // 奇数情况
            String s1 = palindrome(s, i, i);
            // 偶数情况
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        // 结果
        return res;
    }

    String palindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


}
