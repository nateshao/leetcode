package com.nateshao.sword_offer2.Code_50_firstUniqChar;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @date Created by 邵桐杰 on 2022/10/2 12:36
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 剑指 Offer 50. 第一个只出现一次的字符
 */
public class SolutionTest {
    /** hashmap统计
     * 如果s为空，return ' '
     * map 创建hashmap<Character,Boolean>
     * s转换成字符数组
     * 遍历字符数组，如果map添加key的c，map不包含key的c
     * 遍历字符数组，如果map有c，return c；
     * 如果都没找到，就返回为' '
     *
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        if (s.isEmpty()) return ' ';
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc) map.put(c, !map.containsKey(c));
        for (char c : sc) if (map.get(c)) return c;
        return ' ';
    }

    /**
     * 创建‘a'-'z'的字典
     * 第一次遍历，将字符统计到字典数组
     * 第二次遍历，从字典数组获取次数
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        if (s.equals("")) return ' ';
        //创建‘a'-'z'的字典
        int[] target = new int[26];
        //第一次遍历，将字符统计到字典数组
        for (int i = 0; i < s.length(); i++) target[s.charAt(i) - 'a']++;
        //第二次遍历，从字典数组获取次数
        for (int i = 0; i < s.length(); i++) if (target[s.charAt(i) - 'a'] == 1) return s.charAt(i);
        return ' ';
    }
}