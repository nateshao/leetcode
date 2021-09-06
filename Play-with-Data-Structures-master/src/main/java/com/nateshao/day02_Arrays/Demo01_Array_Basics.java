package com.nateshao.day02_Arrays;

/**
 * @date Created by 邵桐杰 on 2021/9/5 23:00
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
public class Demo01_Array_Basics {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;

        int[] scores = new int[]{100, 99, 66};
        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);

        for (int score : scores)
            System.out.println(score);

        scores[0] = 96;

        for (int i = 0; i < scores.length; i++)
            System.out.println(scores[i]);
    }
}
