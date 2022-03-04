package com.nateshao.interview.meituan;

/**
 * @date Created by 邵桐杰 on 2022/3/4 8:44
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */

import java.util.Scanner;

public class Shuixianhuashu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (100 <= m && m <= n && n <= 999) {
                int j = 0;
                for (int i = m; i <= n; i++) {
                    int geWei, shiWei, baiWei;
                    baiWei = i / 100;
                    shiWei = (i - baiWei * 100) / 10;
                    geWei = i - baiWei * 100 - shiWei * 10;
                    if (i == geWei * geWei * geWei + shiWei * shiWei * shiWei + baiWei * baiWei * baiWei) {
                        j = j + 1;
                        if (j > 1) {
                            System.out.println(" " + i);
                        } else {
                            System.out.print(i);
                        }
                    }
                    if (j == 0) {
                        System.out.print("no");
                    }
                    System.out.println();
                }
            }
        }

    }
}
