package com.nateshao.sword_offer3.day3;

/**
 * @date Created by 邵桐杰 on 2022/5/26 23:18
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Day3_2reverseLeftWords {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println("reverseLeftWords(s,2) = " + reverseLeftWords(s, 2));
    }

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
