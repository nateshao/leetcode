package com.nateshao.albaba_03_14;

import java.util.Arrays;

/**
 * @date Created by 邵桐杰 on 2022/3/14 19:42
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Main {
    public static void main(String[] args) {

        int[][] arr = {{2, 4}, {0, 1, 0, 0}, {1, 0, 1, 0}};
        int number = getNumber(arr);
        System.out.println("number = " + number);
    }

    public static int getNumber(int[][] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (arr[i][j] == 0) {
                    return 0;
                }
                if (arr[i][j] != 0) {
//                    arr[i][j]++;
                    count++;
                }
            }
        }
        return count;
    }
}
