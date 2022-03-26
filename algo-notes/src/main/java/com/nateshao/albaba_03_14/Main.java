package com.nateshao.albaba_03_14;

import java.util.*;

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
        int[][] arr = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}};
        System.out.println(big(arr));
        for (int i = 0; i < big(arr).length-1; i++) {
            for (int j = i; j < big(arr).length; j++) {
                System.out.println(arr[i][j]);
            }
        }
//        int[] s = {1,1,0,1,1};
//        Arrays.sort(s);
//        for (int i : s) {
//            System.out.print(i+" ");
//        }
//
//        ArrayList<int[]> list = new ArrayList<>();
//        Stack<int[]> res = new Stack<>();
//        res.push(s);
//        if (res.pop().equals(res.push(s))){
//            list.add(res.pop());
//        }
//        list.stream().forEach(lists->System.out.println("s = " + lists));
    }

    /**
     * 将原来的数组变大几倍
     * 思路：将(x,y)的坐标放大到 *k倍
     *
     * @param arr
     * @return
     */
    public static int[][] big(int[][] arr) {
        int x = 2, y = 2;
        if (arr.length == 0) return new int[0][0];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                arr[i][j] *= arr[x][y];
            }
        }
        return new int[x][y];
    }
}
