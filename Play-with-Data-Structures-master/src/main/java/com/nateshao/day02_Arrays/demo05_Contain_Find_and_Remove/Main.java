package com.nateshao.day02_Arrays.demo05_Contain_Find_and_Remove;

import java.util.Scanner;
/**
 * @date Created by 邵桐杰 on 2021/9/6 15:58
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入一个正整数:");
        int num = input.nextInt();
        while (num != 0) {
            int b = num % 10;
            num = num / 10;
            System.out.print(b);
        }
    }

}
