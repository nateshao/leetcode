package com.nateshao.source.code.java_base.base;

/**
 * @date Created by 邵桐杰 on 2023/2/21 15:44
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class For_99 {
    public static void main(String[] args) {
        int i, j;
        for (i = 9; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=");
                System.out.printf("%-4d", i * j);
            }
            System.out.println();

        }
    }
}
