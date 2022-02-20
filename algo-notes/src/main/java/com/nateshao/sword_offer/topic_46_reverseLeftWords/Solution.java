package com.nateshao.sword_offer.topic_46_reverseLeftWords;

/**
 * @date Created by 邵桐杰 on 2022/2/20 19:46
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println("reverseLeftWords1(s,2) = " + reverseLeftWords1(s, 2));
    }

    /**
     * 方法一：字符串切片
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }


}
