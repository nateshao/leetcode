package com.nateshao.other;

/**
 * @date Created by 邵桐杰 on 2022/9/26 18:26
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description: 统计字符串第一次出现三次的情况
 */
public class Main3 {
    public static void main(String[] args) {
        String s = "abcabccba";
        System.out.println("getThreeTime(s) = " + getThreeTime(s));
        System.out.println("getThreeTime2(s) = " + getThreeTime2(s));
    }

    /**
     * 先转换为字符数组
     * 再比较
     *
     * @param str
     * @return
     */
    public static char getThreeTime(String str) {
        char[] chars = str.toCharArray();
        int[] number = new int[255];// 统计次数
        for (int i = 0; i < str.length() - 1; i++) {
            char c = chars[i];
            if ((c > 'A' && c < 'Z') || (c > 'a' && c < 'z')) number[c]++;
            if (number[c] == 3) return c;
        }
        return ' ';
    }

    public static char getThreeTime2(String str) {
        int[] res = new int[26];
        for (char c : str.toCharArray()) {
            if (++res[c - 'a'] == 3) {
                return c;
            }
        }
        return 0;
    }
}
