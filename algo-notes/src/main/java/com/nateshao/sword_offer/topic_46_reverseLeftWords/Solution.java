package com.nateshao.sword_offer.topic_46_reverseLeftWords;

/**
 * @date Created by 邵桐杰 on 2022/2/20 19:46
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
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
        System.out.println("reverseLeftWords1(s,2) = " + reverseLeftWords1(s, 2));// reverseLeftWords1(s,2) = cdefgab
        System.out.println("reverseLeftWords2(s,2) = " + reverseLeftWords2(s, 2)); // cdefgab
        System.out.println("reverseLeftWords3(s,2) = " + reverseLeftWords3(s, 2));
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

    /**
     * 方法二：列表遍历拼接
     *
     * 算法流程：
     * 1. 新建一个StringBuilder(Java) ，记为 res ；
     * 2. 先向 res 添加 “第 n + 1 位至末位的字符” ；
     * 3. 再向 res 添加 “首位至第 n 位的字符” ；
     * 4. 将 res 转化为字符串并返回。
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords2(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            res.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static String reverseLeftWords3(String s, int n) {
        String res = "";
        for (int i = n; i < s.length(); i++) {
            res += s.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            res+=s.charAt(i);
        }
        return res;
    }


}
