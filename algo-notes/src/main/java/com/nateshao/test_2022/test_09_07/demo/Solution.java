package com.nateshao.test_2022.test_09_07.demo;

/**
 * @date Created by 邵桐杰 on 2022/9/7 19:38
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 2022-09-07
 * 同城旅行
 */
public class Solution {
    public static void main(String[] args) {
        String s = "level";
        String s1 = longestPrefix2(s);
        System.out.println("s1 = " + s1);
    }

    /**
     * 题目：给你一个字符串，请你返回最长的一段字符串，这段字符串存在于已知的字符串收尾
     * <p>
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longestPrefix
     *
     * @param s string字符串 输入字符串
     * @return string字符串
     */
    public static String longestPrefix(String s) {
        int len = s.length();
        char[] p = s.toCharArray();
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        int j = 1;
        int k = 0;
        int mat = -1;
        while (j < len - 1) {
            if (k == -1) {
                j++;
                k = 0;
                next[j] = 0;
            } else if (p[j] == p[k]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
            for (int i = 0; i < len; i++) {
                mat = Math.max(next[k + 1], mat);
            }
        }
        return s.substring(0, mat);
    }


    public static String longestPrefix2(String s) {
        int len = s.length();                  //获取模式串的长度
        char[] p = s.toCharArray();             //把模式串转换成char数组
        int[] next = new int[len];              //声明next数组,最后返回
        next[0] = -1;
        next[1] = 0;
        int j = 1;
        int k = 0;
        int mat = -1;                //next[j]=k  k就是next数组中的值

        while (j < len - 1) {
            if (k == -1) {        //回溯到0都不匹配,则next值为0
                j++;
                k = 0;
                next[j] = 0;
            } else if (p[j] == p[k]) {     //找到了匹配的,对应next值+1
                j++;
                k++;
                next[j] = k;
            } else {                    //不匹配,指针回溯
                k = next[k];
            }

        }
        for (int i = 0; i < len; i++) {
            mat = Math.max(next[i] + 1, mat);
        }
        s = s.substring(0, mat);
        return s;
    }
}
