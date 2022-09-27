package com;

import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/9/27 11:55
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class MainTest {
    public static void main(String[] args) {
        String s = "abcc";
        System.out.println("lengthOfLongestSubstring3(s) = " + lengthOfLongestSubstring3(s));
    }

    /**
     * 无重复字符的最长子串
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
    }

}