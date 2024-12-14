package com;


import java.util.HashSet;

/**
 * @date Created by 邵桐杰 on 2022/9/27 11:55
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class MainTest {
    public static void main(String[] args) {
        String s = "abcc";
        System.out.println("lengthOfLongestSubstring3(s) = " + lengthOfLongestSubstring4(s));
    }

    /**
     * 无重复字符的最长子串长度
     * 滑动窗口 + hashset
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
        return res;
        // abcc   返回abc
    }

    public static String lengthOfLongestSubstring4(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, res = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            res = Math.max(res, set.size());
        }
//        set.toArray(new String(set.size()));
        return s.substring(left, right);
    }
}