package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @date Created by 邵桐杰 on 2022/9/26 16:15
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main2 {

    public static void main(String[] args) {
        String s = "i love you";
        String s1 = reverseWords2(s);
        System.out.println("s1 = " + s1);
    }
    /**
     * 借助一个额外的数组存储
     */
    public static String reverseWords1(String s) {
        List<String> list = new ArrayList<>();
        String[] words = s.split(" ");
        for (String word : words) {
            if (word.trim().length() > 0) {
                list.add(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 另一种写法
     */
    public static String reverseWords2(String s) {
        String[] words = s.split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
