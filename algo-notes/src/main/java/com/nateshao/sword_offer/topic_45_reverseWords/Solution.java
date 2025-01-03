package com.nateshao.sword_offer.topic_45_reverseWords;

import javax.swing.*;

/**
 * @date Created by 邵桐杰 on 2022/1/27 16:18
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Solution {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println("reverseWords1(s) = " + reverseWords1(s));
//        System.out.println("reverseSentence(s) = " + reverseSentence(s));//reverseSentence(s) = blue is sky the
//        System.out.println("reverseWords2(s) = " + reverseWords2(s));
    }

    /**
     * 双指针
     * 1. 倒序遍历字符串，记录单词左右索引边界i,j
     * 2. 每确定单词的边界，放入res
     * 3. 最后，拼接成字符串，返回即可
     *
     * @param s
     * @return
     */
    public static String reverseWords1(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            // 搜索首个空格，添加单词
            // 是字母就添加进去
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            // 是空格的话，跳过单词间空格，j就指向下一个单词尾字符。
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();// 转化为字符串，并且返回
    }

    // 方法二：分割 + 倒序 （面试时不建议使用）
    public static String reverseWords2(String s) {
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = strs.length - 1; i >= 0; i--) {
            // 遇到空格则跳过
            if (strs[i].equals("")) continue;
            // 将单词拼接到StringBuilder()
            res.append(strs[i] + " ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }

    /**
     * 剑指offer PDF
     *
     * @param sentence
     * @return
     */
    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.length() == 0 || sentence.trim().length() == 0) {
            return sentence;
        }
        String blank = " ";
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(blank);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitStrings.length - 1; i++) {
            sb.append(reverse(splitStrings[i])).append(blank);
        }
        sb.append(reverse(splitStrings[splitStrings.length - 1]));
        return String.valueOf(sb);
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return String.valueOf(sb);
    }
}
