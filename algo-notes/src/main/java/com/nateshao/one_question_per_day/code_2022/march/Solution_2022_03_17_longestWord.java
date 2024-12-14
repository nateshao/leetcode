package com.nateshao.one_question_per_day.code_2022.march;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @date Created by 邵桐杰 on 2022/3/17 20:08
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution_2022_03_17_longestWord {
    public static void main(String[] args) {
        String[] words = {"w", "wo", "wor", "worl", "world"};
        String s = longestWord(words);
        System.out.println("s = " + s);
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String s : words) {
            //如果单词只有一个字母，那一定是共有的
            if (s.length() == 1 || set.contains(s.substring(0, s.length() - 1))) {
                res = s.length() > res.length() ? s : res;
                set.add(s);
            }
        }
        return res;
    }
}
