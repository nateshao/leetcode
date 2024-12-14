package com.nateshao.interview.meituan;

/**
 * @date Created by 邵桐杰 on 2022/3/4 8:29
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * Description: 求数列前n项和
 */

import java.util.*;

public class Qiushule {

    public static void main(String[] args) {
        int m;
        double sum, n;
        // 系统录入
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            sum = 0;
            for (int i = 0; i < m; i++) {
                sum = sum + n;
                n = Math.sqrt(n);
            }
            System.out.printf("%0.2f", sum);
            System.out.println();
        }
    }
}
