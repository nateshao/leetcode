package com.nateshao.source.code.java_base.base;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2023/2/21 13:25
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description: 键盘录入
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int c = sc.nextInt();
//        System.out.println(b + c);
        if (b > c) System.out.println(b);
        else System.out.println(c);
    }

}
