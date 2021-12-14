package com.nateshao.sword_offer.topic_37_firstUniqChar;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @date Created by 邵桐杰 on 2021/12/14 18:15
 * @微信公众号 程序员千羽
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 示例 1: 输入：s = "abaccdeff"   输出：'b'
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abaccdeff";
        String s2 = "";
        System.out.println("firstUniqChar(s) = " + firstUniqChar(s));//firstUniqChar(s) = b
        System.out.println("firstUniqChar(s2) = " + firstUniqChar(s2));
    }

    /**
     * 利用 HashMap 和 LinkedHashMap 保存字符和出现次数。
     * @param s
     * @return
     */
    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) return ' ';
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> hashMap = new HashMap<>();
//        LinkedHashMap<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
        for (char c : chars) {
            hashMap.put(c, !hashMap.containsKey(c));
        }
        for (char c : chars) {
            if (hashMap.get(c)) return c;
        }
        return ' ';
    }
}
