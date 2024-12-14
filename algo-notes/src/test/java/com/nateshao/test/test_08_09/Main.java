package com.nateshao.test.test_08_09;

import java.util.HashMap;

/**
 * @date Created by 邵桐杰 on 2022/8/9 21:18
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 输入一个字符串，比如“abcbaddd”,返回这个字符串中的最长回文子串
 * 1. 统计每个字符出现的次数，并且排序，
 * c  bb aa  ddd
 * 思路1：暴力破解
 * 2，hashmap
 * 3,双指针
 *
 **/
public class Main {
    /**
     * 思路1：双层循环
     * 思路2：哈希
     *  1,转换成字符数组。
     *  2，如果hashmap去统计
     *      如果含有的话就++；
     *
     *  a,ab,abc,abcba,bcb
     *  最长 abcba
     * @param s
     * @return
     */
    public String longMaxString(String s){
        HashMap<Integer, String> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(i,map.get(i));
            }


        }




        return null;
    }

}
