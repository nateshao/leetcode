package com.nateshao.test.test_09_09;

import java.util.Scanner;

/**
 * @date Created by 邵桐杰 on 2022/9/9 18:02
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int length = sc.nextInt();
//        int[] res = new int[length];
        int target = 5;
        int[] arr = {5, 1, 2, 1, 5};

        int num = getNum(arr, target);
        System.out.println(num);

    }

    public static int getNum(int[] arr, int target) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) res++;
        }
        return res;
    }
}
