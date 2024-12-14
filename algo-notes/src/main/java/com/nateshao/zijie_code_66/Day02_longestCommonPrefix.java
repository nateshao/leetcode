package com.nateshao.zijie_code_66;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/3/9 8:51
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: https://leetcode-cn.com/problems/longest-common-prefix/
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Day02_longestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("longestCommonPrefix(strs) = " + longestCommonPrefix(strs));
        System.out.println("longestCommonPrefix2(strs) = " + longestCommonPrefix2(strs));
    }
    /**
     * 取一个单词 s，和后面单词比较，看 s 与每个单词相同的最长前缀是多少！遍历所有单词。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String str = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
            i += 1;
        }
        return str;
    }

    /**
     * 按字典排序数组，比较第一个，和最后一个单词，有多少前缀相同。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        Arrays.sort(strs);
        // 字符串转数组
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length - 1].toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i < b.length && a[i] == b[i]) {
                builder.append(a[i]);
            }else {
                break;
            }
        }
        return builder.toString();
    }
}
