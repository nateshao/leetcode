package com.nateshao.sword_offer3.day5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/5/30 20:43
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 * 输入：s = "abaccdeff"
 * 输出：'b'
 *
 * 示例 2:
 * 输入：s = ""
 * 输出：' '
 */
public class Day5_firstUniqChar {
    public char firstUniqChar(String s) {
//        HashMap<Character, Boolean> dic = new HashMap<>();
//        char[] sc = s.toCharArray();
//        for(char c : sc)
//            dic.put(c, !dic.containsKey(c));
//        for(char c : sc)
//            if(dic.get(c)) return c;
//        return ' ';
            HashMap<Character, Boolean> dic = new HashMap<>();
            char[] sc = s.toCharArray();
            for(char c : sc)
                dic.put(c, !dic.containsKey(c));
            for(char c : sc)
                if(dic.get(c)) return c;
            return ' ';
        }

}
