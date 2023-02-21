package com.nateshao.source.code.java_base.base;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2023/2/21 14:04
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Scanner_score {
    public static void main(String[] args) {
        System.out.println("请输入你的成绩：");
        Scanner input = new Scanner(System.in);
        float achivment = input.nextInt();// 接收键盘输入数据
        if (achivment >= 90) { // 考试成绩>=90
            System.out.println("你的成绩是：优秀");
        } else if (achivment >= 80) { // 考试成绩80<=成绩<90
            System.out.println("你的成绩是：良好");
        } else if (achivment >= 60) { // 考试成绩60<=成绩<80
            System.out.println("你的成绩是：中等");
        } else {                      // 考试成绩<60
            System.out.println("你的成绩是：差！");
        }
    }
}
