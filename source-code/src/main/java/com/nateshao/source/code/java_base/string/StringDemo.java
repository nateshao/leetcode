package com.nateshao.source.code.java_base.string;

/**
 * @date Created by 邵桐杰 on 2023/2/22 0:07
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class StringDemo {
    public static void main(String[] args) {
//        String s1 = "abc";
//        String s2 = "abc";
//        System.out.println(s1 == s2); // true
//        System.out.println(s1.equals(s2)); // true

        String s1 = new String("abc");
        String s2 = "abc";
        System.out.println(s1 == s2);         //    false
        System.out.println(s1.equals(s2));  //  true
    }
}
