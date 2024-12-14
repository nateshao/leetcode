package com.nateshao.test.test_09_09;

/**
 * @date Created by 邵桐杰 on 2022/9/9 16:11
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 字符串反转
 */
public class Main {
    public static void main(String[] args) {
        String str = "abc";
        String res = reverse(str);
        System.out.println(res);
    }
    /**
     * Junit
     * @param str
     * @return
     */
    public static String reverse(String str){
        StringBuilder res = new StringBuilder(str);
        StringBuilder reverse = res.reverse();
//        System.out.println(reverse.toString());
        return reverse.toString();
    }

}
