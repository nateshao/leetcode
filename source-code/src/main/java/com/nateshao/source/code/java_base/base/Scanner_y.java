package com.nateshao.source.code.java_base.base;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2023/2/21 14:06
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Scanner_y {
    public static void main(String[] args) {
        int y;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数x的值：");
        int x = sc.nextInt();
        if (x >= 3) {        //当x大于3时
            y = 2 * x + 1;
        } else if (x > -1 && x < 3) {    //x>-1且x<3两个条件同时成立时
            y = 2 * x;
        } else {          //以上两种情况以外
            y = 2 * x - 1;
        }
        System.out.println("y的值为：" + y);   //输出y的值
    }
}
