package com.nateshao.test.test2025;

/**
 * @date Created by 邵桐杰 on 2022/6/23 17:13
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        String res = reverseWord(s);
        System.out.println(res);
    }

    /**
     * 输入一个字符串
     * 输出以单词维度的反转
     *
     * @param s
     * @return
     */
    public static String reverseWord(String s) {
        String[] words = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i != 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
